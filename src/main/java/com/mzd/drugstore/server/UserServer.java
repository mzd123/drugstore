package com.mzd.drugstore.server;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.mzd.drugstore.bean.MyResult;
import com.mzd.drugstore.bean.backresult.MyOrderWithOther;
import com.mzd.drugstore.bean.backresult.Mycar;
import com.mzd.drugstore.bean.generator.*;
import com.mzd.drugstore.constant.Constant;
import com.mzd.drugstore.dao.CommonDao;
import com.mzd.drugstore.dao.ProductDao;
import com.mzd.drugstore.dao.UserDao;
import com.mzd.drugstore.utils.IpUtils;
import com.mzd.drugstore.utils.MyStringUtils;
import com.mzd.drugstore.utils.ResultUtils;
import com.mzd.drugstore.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.FetchProfile;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServer {
    @Autowired
    private UserDao userDao;
    @Autowired
    private CommonDao commonDao;
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 修改用户信息
     *
     * @param user
     * @return
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public MyResult update_myinfoS(User user) {
        int i = userDao.update_myinfoD(user);
        if (i > 0) {
            /**
             * 操作日志表
             */
            MyLog myLog = new MyLog();
            myLog.setTableId(user.getUserId());
            myLog.setUseId(user.getUserId());
            myLog.setTablename(Constant.cs_user);
            myLog.setLogId(MyStringUtils.getuuid());
            //获取request
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            myLog.setOptionip(IpUtils.getIp(request));
            myLog.setOptionconent(Constant.update);
            myLog.setCreatetime(TimeUtils.get_current_time());
            int k = commonDao.insertLogD(myLog);
            if (k > 0) {
                return ResultUtils.getResult("200", "修改用户信息成功", null, 0);
            }
            return ResultUtils.getResult("200", "修改用户信息成功,但日志更新失败", null, 0);
        } else {
            return ResultUtils.getResult("500", "服务器内部错误", null, 0);
        }
    }

    /**
     * 添加评论
     *
     * @param user
     * @param productid
     * @param commentContent
     * @param imgs
     * @return
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int add_commentS(User user, String productid, String commentContent, MultipartFile[] imgs, String commentLevel) throws Exception {

        /**
         * 操作评论表
         */
        Comment comment = new Comment();
        comment.setCommentContent(commentContent);
        comment.setProductId(productid);
        comment.setCommentCreatetime(TimeUtils.get_current_time());
        comment.setUserId(user.getUserId());
        comment.setCommentStatus(Constant.liefstatus);
        comment.setCommentId(MyStringUtils.getuuid());
        //评论等级- - - 默认是中等评价
        if (MyStringUtils.Object2String(commentLevel).equals("")) {
            commentLevel = "3";
        }
        comment.setCommentLevel(commentLevel);
        /**
         * 保存评论
         */
        userDao.insertcommentD(comment);
        /**
         * 操作日志表
         */
        MyLog myLog = new MyLog();
        myLog.setCreatetime(TimeUtils.get_current_time());
        //获取request
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        myLog.setOptionip(IpUtils.getIp(request));
        myLog.setLogId(MyStringUtils.getuuid());
        myLog.setTableId(comment.getCommentId());
        myLog.setTablename(Constant.cs_comment);
        myLog.setUseId(user.getUserId());
        myLog.setOptionconent(Constant.insert);
        commonDao.insertLogD(myLog);

        /**
         * 将图片存入服务器中
         */
        if (imgs != null && imgs.length > 0) {
            File file = new File(Constant.path_comment + user.getUserId() + "/" + productid);
            if (!file.exists()) {
                //不存在目录就创建
                file.mkdirs();
            }
            List<Commentimgs> list = new ArrayList<>();
            for (int i = 0; i < imgs.length; i++) {
                String imgid = MyStringUtils.getuuid();
                File file1 = new File(Constant.path_comment + user.getUserId() + "/" + productid + "/" + imgid + "_" + imgs[i].getOriginalFilename());
                imgs[i].transferTo(file1);
                Commentimgs commentimgs = new Commentimgs();
                commentimgs.setImgid(imgid);
                commentimgs.setImgpath(Constant.path_comment + user.getUserId() + "/" + productid + "/" + imgid + "_" + imgs[i].getOriginalFilename());
                commentimgs.setImgStatus(Constant.liefstatus);
                commentimgs.setCommentid(comment.getCommentId());
                list.add(commentimgs);
            }
            for (int i = 0; i < list.size(); i++) {
                /**
                 * 将评论图片入库 - - - 数量不多，就不单独写批处理了
                 */
                Commentimgs commentimgs = list.get(i);
                userDao.insertCommentimgsD(commentimgs);
                myLog = new MyLog();
                myLog.setCreatetime(TimeUtils.get_current_time());
                myLog.setOptionip(IpUtils.getIp(request));
                myLog.setLogId(MyStringUtils.getuuid());
                myLog.setTableId(commentimgs.getImgid());
                myLog.setTablename(Constant.cs_commentimgs);
                myLog.setUseId(user.getUserId());
                myLog.setOptionconent(Constant.insert);
                commonDao.insertLogD(myLog);
            }
        }
        /**
         * 删除redis中的缓存数据
         */
        redisTemplate.delete(redisTemplate.keys(Constant.commentlist4productid + productid + "*"));
        redisTemplate.delete(redisTemplate.keys(Constant.commentall4productid + productid + "*"));
        return 1;
    }

    /**
     * 查询我的购物车
     *
     * @return
     */
    public MyResult select_my_carS() {
        //获取request
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        User user = (User) request.getSession().getAttribute("user");
        String string = (String) redisTemplate.opsForValue().get(Constant.mycar + user.getUserId());
        List<Mycar> mycarlist = new ArrayList<>();
        if (!MyStringUtils.Object2String(string).equals("")) {
            mycarlist = JSONObject.parseArray(string, Mycar.class);
        } else {
            mycarlist = userDao.select_my_carD(user.getUserId());
            redisTemplate.opsForValue().set(Constant.mycar + user.getUserId(), JSON.toJSONString(mycarlist));
        }
        return ResultUtils.getResult("200", "查询成功", mycarlist, 0);
    }

    /**
     * 加入购物车
     *
     * @param productId
     * @param productNumber
     * @param itemsMoney
     * @return
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public MyResult add_my_carS(String productId, String productNumber, String itemsMoney) {
        //获取当前用户id
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        User user = (User) request.getSession().getAttribute("user");
        String userid = user.getUserId();
        /**
         * 日志处理
         */
        MyLog myLog = new MyLog();
        myLog.setOptionip(IpUtils.getIp(request));
        myLog.setUseId(userid);
        myLog.setTablename(Constant.cs_items);
        myLog.setLogId(MyStringUtils.getuuid());
        myLog.setCreatetime(TimeUtils.get_current_time());
        /**
         * 先查询当前用户购物车中是否含有这个商品 - - - 没有下过单的，下过单的不算
         */
        List<Items> list = userDao.select_my_items_by_PidAndUid(productId, userid);
        if (list != null && list.size() > 0) {
            //原来购物车里面有这个商品
            /**
             * 更新商品数量和小计即可
             */
            Items items = list.get(0);
            //更新商品数量
            items.setProductNumber(Integer.valueOf(items.getProductNumber()) + Integer.valueOf(productNumber) + "");
            //更新商品小计
            items.setItemsMoney(Integer.valueOf(items.getItemsMoney()) + Integer.valueOf(itemsMoney) + "");
            userDao.update_itemsD(items);
            myLog.setTableId(items.getItemsId());
            myLog.setOptionconent(Constant.update);
        } else {
            //原来购物车中没有这个商品 - - - 新增这个商品项
            Items items = new Items();
            items.setItemsMoney(itemsMoney);
            items.setProductNumber(productNumber);
            items.setItemsId(MyStringUtils.getuuid());
            items.setItemsStatus(Constant.liefstatus);
            items.setOrderId(" ");
            items.setUserId(userid);
            items.setProductId(productId);
            userDao.insertItems(items);
            myLog.setTableId(items.getItemsId());
            myLog.setOptionconent(Constant.insert);
        }
        /**
         * 操作日志
         */
        commonDao.insertLogD(myLog);
        //删除redis中我的购物车缓存
        redisTemplate.delete(redisTemplate.keys(Constant.mycar + user.getUserId()));
        return ResultUtils.getResult("200", "加入购物车成功", null, 0);
    }

    /**
     * 删除商品项
     *
     * @param itemid
     * @return
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public MyResult delete_my_carS(String itemid) {
        //获取userid
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        User user = (User) request.getSession().getAttribute("user");
        String userid = user.getUserId();
        /**
         * 查询这个商品项
         */
        List<Items> items = userDao.select_Items_by_itemid(itemid);
        if (items != null && items.size() > 0) {
            Items items1 = items.get(0);
            if (items1.getOrderId().equals("")) {
                items1.setItemsStatus(Constant.deletedstatus);
                userDao.update_itemsD(items1);
                /**
                 * 操作日志
                 */
                MyLog myLog = new MyLog();
                myLog.setOptionconent(Constant.delete);
                myLog.setTableId(items1.getItemsId());
                myLog.setCreatetime(TimeUtils.get_current_time());
                myLog.setLogId(MyStringUtils.getuuid());
                myLog.setOptionip(IpUtils.getIp(request));
                myLog.setTablename(Constant.cs_items);
                myLog.setUseId(userid);
                commonDao.insertLogD(myLog);
                /**
                 * 删除我的redis中购物车缓存
                 */
                redisTemplate.delete(redisTemplate.keys(Constant.mycar + user.getUserId()));
                return ResultUtils.getResult("200", "商品项删除成功", null, 0);
            }
            return ResultUtils.getResult("400", "该商品项已经下单", null, 0);
        }
        return ResultUtils.getResult("400", "商品项id有误或者已经被删除", null, 0);
    }

    /**
     * 查询我的收货地址
     *
     * @return
     */
    public MyResult select_my_addressS() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        User user = (User) request.getSession().getAttribute("user");
        String userid = user.getUserId();
        String string = (String) redisTemplate.opsForValue().get(Constant.address + userid);
        List<Address> list = new ArrayList<>();
        if (MyStringUtils.Object2String(string).equals("")) {
            list = userDao.select_address(userid);
            redisTemplate.opsForValue().set(Constant.address + userid, JSON.toJSONString(list));
        } else {
            list = JSONObject.parseArray(string, Address.class);
        }
        return ResultUtils.getResult("200", "查询我的收货地址成功", list, 0);
    }

    /**
     * 新增收货地址
     *
     * @param address
     * @return
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public MyResult add_my_address(String address) {
        Address address1 = new Address();
        address1.setAddressCreatetime(TimeUtils.get_current_time());
        address1.setAddressLocation(address);
        address1.setAddressStatus(Constant.liefstatus);
        address1.setAddressId(MyStringUtils.getuuid());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        User user = (User) request.getSession().getAttribute("user");
        address1.setUserid(user.getUserId());
        userDao.add_my_address(address1);
        /**
         * 操作日志
         */
        MyLog myLog = new MyLog();
        myLog.setUseId(user.getUserId());
        myLog.setTablename(Constant.cs_address);
        myLog.setOptionip(IpUtils.getIp(request));
        myLog.setCreatetime(TimeUtils.get_current_time());
        myLog.setTableId(address1.getAddressId());
        myLog.setOptionconent(Constant.insert);
        myLog.setLogId(MyStringUtils.getuuid());
        commonDao.insertLogD(myLog);
        redisTemplate.delete(redisTemplate.keys(Constant.address + user.getUserId()));
        return ResultUtils.getResult("200", "新增地址成功", null, 0);
    }

    /**
     * 删除收货地址
     *
     * @param addressid
     * @return
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public MyResult delete_my_addressD(String addressid) {
        /**
         * 先查询这个地址是否存在
         */
        List<Address> list = userDao.selectaddress_byaddressid(addressid);
        if (list != null && list.size() > 0) {
            Address address = list.get(0);
            address.setAddressStatus(Constant.deletedstatus);
            userDao.updateaddress(address);
            /**
             * 操作日志
             */
            MyLog myLog = new MyLog();
            myLog.setLogId(MyStringUtils.getuuid());
            myLog.setOptionconent(Constant.delete);
            myLog.setCreatetime(TimeUtils.get_current_time());
            myLog.setTablename(Constant.cs_address);
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            User user = (User) request.getSession().getAttribute("user");
            myLog.setUseId(user.getUserId());
            myLog.setOptionip(IpUtils.getIp(request));
            myLog.setTableId(address.getAddressId());
            commonDao.insertLogD(myLog);
            redisTemplate.delete(redisTemplate.keys(Constant.address + user.getUserId()));
            return ResultUtils.getResult("200", "收货地址删除成功", null, 0);
        }
        return ResultUtils.getResult("400", "收货地址id有误或者已经被删除", null, 0);
    }

    /**
     * 下单
     *
     * @param list
     * @return
     */
    @Transactional(isolation = Isolation.REPEATABLE_READ, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public MyResult get_an_orderS(List<String> list, String addressid, String receiver, String tel) {
        /**
         * 先根据商品项id集合获取商品项对象集合
         */
        List<Items> list1 = userDao.getItems_by_itemsidsD(list);
        if (list1 != null && list1.size() > 0) {
            //获取request
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();
            User user = (User) request.getSession().getAttribute("user");
            String userid = user.getUserId();
            String orderid = MyStringUtils.getuuid();
            //订单总额
            int order_summoney = 0;
            for (Items e : list1) {
                //System.out.println(e.toString());
                String itemsMoney = e.getItemsMoney();
                order_summoney += Integer.valueOf(itemsMoney);
                //==========================这部分付款之后再执行=============================
//                /**
//                 * 更新商品项中的订单id字段
//                 */
//                e.setOrderId(orderid);
//                userDao.update_itemsD(e);
//                /**
//                 * 操作日志表
//                 */
//                MyLog myLog = new MyLog();
//                myLog.setTableId(e.getItemsId());
//                myLog.setCreatetime(TimeUtils.get_current_time());
//                myLog.setOptionip(IpUtils.getIp(request));
//                myLog.setTablename(Constant.cs_items);
//                myLog.setOptionconent(Constant.update);
//                myLog.setLogId(MyStringUtils.getuuid());
//                myLog.setUseId(userid);
//                commonDao.insertLogD(myLog);
                //==========================这部分付款之后再执行=============================
            }
            /**
             * 产生订单 - - - 先存入redis中，设置半小时有效时间，半小时后自动被认为放弃付款
             */
            Order order = new Order();
            order.setAddressId(addressid);
            order.setOrderCreatetime(TimeUtils.get_current_time());
            order.setOrderId(orderid);
            //订单来源于下单
            order.setOrderOrigin(Constant.firstorder);
            //待付款状态
            order.setOrderStage(Constant.Pending_payment);
            order.setOrderStatus(Constant.liefstatus);
            order.setOrderSummoney(order_summoney + "");
            order.setReceiver(receiver);
            order.setTel(tel);
            //==========================这部分付款之后再执行=============================
//            userDao.insertOrder(order);
//            /**
//             * 操作日志表
//             */
//            MyLog myLog = new MyLog();
//            myLog.setTableId(orderid);
//            myLog.setCreatetime(TimeUtils.get_current_time());
//            myLog.setOptionip(IpUtils.getIp(request));
//            myLog.setTablename(Constant.cs_order);
//            myLog.setOptionconent(Constant.insert);
//            myLog.setLogId(MyStringUtils.getuuid());
//            myLog.setUseId(userid);
//            commonDao.insertLogD(myLog);

            //删除redis中我的购物车缓存---因为我的购物车中有些商品项已经被下单了
            // redisTemplate.delete(redisTemplate.keys(Constant.mycar + userid));
            //==========================这部分付款之后再执行=============================
            /**
             * 返回去对象：
             * 商品主图片
             * 商品名字
             * 商品描述
             * 商品价格
             * 商品个数
             * 小计金额
             * 订单id
             * 订单状态
             */
            MyOrderWithOther myOrderWithOther = new MyOrderWithOther();

            return ResultUtils.getResult("200", "下单成功", order, 0);
        }
        return ResultUtils.getResult("400", "商品项id集合json有误，找不到任何一个商品项", null, 0);
    }
}
