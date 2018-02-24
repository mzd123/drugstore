package com.mzd.drugstore.constant;


public interface Constant {
    /**
     * 所有用户uri头部
     */
    String drugstore = "/drugstore/";
    /**
     * 需要登入之后才能访问的uri需要加上这个
     */
    String authority = "authoritys/";
    /**
     * 状态是被删除
     */
    String deletedstatus = "0";
    /**
     * 状态是未被删除
     */
    String liefstatus = "1";
    /**
     * 系统图片路径-商品
     */
    String path_product = System.getProperty("user.dir") + "/imgs/product/";
    /**
     * 系统图片路径-评论
     */
    String path_comment = System.getProperty("user.dir") + "/imgs/comment/";
    /**
     * 普通用户角色
     */
    String generaluserR_id = "1";
    /**
     * 操作员
     */
    String operatorR_id = "2";
    /**
     * 管理员角色
     */
    String adminR_id = "3";
    /**
     * 表名
     */
    String cs_authority = "cs_authority";
    String cs_role = "cs_role";
    String cs_user = "cs_user";
    String cs_address = "cs_address";
    String cs_order = "cs_order";
    String cs_productclass = "cs_productclass";
    String cs_product = "cs_product";
    String cs_comment = "cs_comment";
    String cs_car = "cs_car";
    String cs_items = "cs_items";
    String cs_afterserver = "cs_afterserver";
    String cs_server = "cs_server";
    String cs_storemessage = "cs_storemessage";
    String cs_log = "cs_log";
    String cs_buy = "cs_buy";
    String cs_afterserverimgs = "cs_afterserverimgs";
    String cs_productimgs = "cs_productimgs";
    String cs_commentimgs = "cs_commentimgs";
    /**
     * 对系统的操作内容
     */
    String insert = "新增";
    String update = "修改";
    String select = "查询";
    String delete = "删除";
    String login = "登入";
    String logout = "退出";
    /**
     * 用户缓存
     */
    //用户信息
    String userinfo = "userinfo_";
    //用户的验证码
    String user_verificationcode = "_verificationcode";
    /**
     * 缓存时间
     */
    //验证码5分钟有效
    int verificationcode_time = 60 * 5;
    /**
     * 商品分类
     */
    String productclass = "productclass";
    //商品分类过期时间---一天
    int productclass_time = 60 * 60 * 24;
    //商品分类集合
    String productclasslist = "productclasslist";
    //商品全部信息
    String productinfo = "productinfo";
    //商品集合-信息过期时间----1小时
    int product_time = 60 * 60;
    //商品id为XXX的评论数目
    String commentall4productid = "commentall4productid";
    //商品id为XXX的评论集合
    String commentlist4productid = "commentlist4productid";
}
