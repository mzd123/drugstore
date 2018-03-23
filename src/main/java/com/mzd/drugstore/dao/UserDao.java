package com.mzd.drugstore.dao;

import com.mzd.drugstore.bean.backresult.Mycar;
import com.mzd.drugstore.bean.generator.*;
import com.mzd.drugstore.constant.Constant;
import com.mzd.drugstore.mapper.backresult.ItemsBatchMapper;
import com.mzd.drugstore.mapper.backresult.MyCarMapper;
import com.mzd.drugstore.mapper.generator.*;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDao {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private CommentimgsMapper commentimgsMapper;
    @Autowired
    private ItemsMapper itemsMapper;

    @Autowired
    private MyCarMapper myCarMapper;
    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private ItemsBatchMapper itemsBatchMapper;
    @Autowired
    private OrderMapper orderMapper;

    public int update_myinfoD(User user) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserIdEqualTo(user.getUserId());
        return userMapper.updateByExample(user, userExample);
    }

    /**
     * 新增评论
     *
     * @param comment
     */
    public void insertcommentD(Comment comment) {
        commentMapper.insert(comment);
    }

    /**
     * 评论图片入库
     *
     * @param commentimgs
     */

    public void insertCommentimgsD(Commentimgs commentimgs) {
        commentimgsMapper.insert(commentimgs);
    }

    /**
     * 查询我的购物车
     *
     * @param userId
     * @return
     */
    public List<Mycar> select_my_carD(String userId) {
        return myCarMapper.select_my_carM(userId);
    }

    /**
     * 查询我的商品项中商品id为productId的集合
     *
     * @param productId
     * @param userid
     * @return
     */
    public List<Items> select_my_items_by_PidAndUid(String productId, String userid) {
        ItemsExample itemsExample = new ItemsExample();
        ItemsExample.Criteria criteria = itemsExample.createCriteria();
        criteria.andProductIdEqualTo(productId);
        criteria.andUserIdEqualTo(userid);
        criteria.andItemsStatusEqualTo(Constant.liefstatus);
        /**
         * 并且是沒有下过单的
         */
        criteria.andOrderIdEqualTo("");
        return itemsMapper.selectByExample(itemsExample);
    }

    /**
     * 更新商品项
     *
     * @param items
     */
    public void update_itemsD(Items items) {
        ItemsExample itemsExample = new ItemsExample();
        ItemsExample.Criteria criteria = itemsExample.createCriteria();
        criteria.andItemsIdEqualTo(items.getItemsId());
        itemsMapper.updateByExample(items, itemsExample);
    }

    /**
     * 新增商品项
     *
     * @param items
     */
    public void insertItems(Items items) {
        itemsMapper.insert(items);
    }

    /**
     * @param itemid
     * @return
     */
    public List<Items> select_Items_by_itemid(String itemid) {
        ItemsExample itemsExample = new ItemsExample();
        ItemsExample.Criteria criteria = itemsExample.createCriteria();
        criteria.andItemsIdEqualTo(itemid);
        criteria.andItemsStatusEqualTo(Constant.liefstatus);
        return itemsMapper.selectByExample(itemsExample);
    }

    /**
     * 查询我的收货地址
     *
     * @param userid
     * @return
     */
    public List<Address> select_address(String userid) {
        AddressExample addressExample = new AddressExample();
        AddressExample.Criteria criteria = addressExample.createCriteria();
        criteria.andUseridEqualTo(userid);
        criteria.andAddressStatusEqualTo(Constant.liefstatus);
        /**
         * 按创建时间倒序
         */
        addressExample.setOrderByClause("address_createtime desc");
        return addressMapper.selectByExample(addressExample);
    }

    /**
     * 新增收货地址
     *
     * @param address1
     */
    public void add_my_address(Address address1) {
        addressMapper.insert(address1);
    }

    /**
     * 根据收货地址id查询地址对象
     *
     * @param addressid
     * @return
     */
    public List<Address> selectaddress_byaddressid(String addressid) {
        AddressExample addressExample = new AddressExample();
        AddressExample.Criteria criteria = addressExample.createCriteria();
        criteria.andAddressIdEqualTo(addressid);
        criteria.andAddressStatusEqualTo(Constant.liefstatus);
        return addressMapper.selectByExample(addressExample);
    }

    /**
     * 修改收货地址
     *
     * @param address
     */
    public void updateaddress(Address address) {
        AddressExample addressExample = new AddressExample();
        AddressExample.Criteria criteria = addressExample.createCriteria();
        criteria.andAddressIdEqualTo(address.getAddressId());
        addressMapper.updateByExample(address, addressExample);
    }

    /**
     * 根据商品项id集合获取商品项对象集合
     *
     * @param list
     * @return
     */
    public List<Items> getItems_by_itemsidsD(List<String> list) {
        return itemsBatchMapper.getItems_by_itemsidsM(list);
    }

    /**
     * 新增order表
     *
     * @param order
     */
    public void insertOrder(Order order) {
        orderMapper.insert(order);
    }
}
