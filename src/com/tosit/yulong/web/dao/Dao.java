package com.tosit.yulong.web.dao;

import com.tosit.yulong.web.entity.*;

import java.util.List;

/**
 * Created by zx on 2016/9/26.
 */
public interface Dao {
    //获取所有栏目
    List<LanMu> querryAll();

    //获取所有文章
    List<WenZhang> queryALL();

    //根据栏目id获取指定栏目的所有文章
    List<WenZhang> wenZhangBylm_id(int lm_id);

    // 获取所有酒店
    List<Hotel> hotelsAll();

    //根据酒店id 获取指定酒店
    Hotel hotelByh_id(int h_ids);

    //获取所有景点
    List<JingDian> jdsAll();

    //根据景点id获取指定景点
    JingDian jdByjd_id(int jd_id);

    //获取所有线路
    List<Route>  routesAll();

    //获取指定线路
    Route routeByr_id(int r_id);

    //获取所有门票
    List<Ticket> ticketsAll();

    //获取指定门票
    Ticket ticketByt_id(int t_id);

    //购物车添加预购门票
    void addCartByt_id(int t_id, String t_name, int t_price);

    //购物车删除预购门票
    void delCartByt_id(int t_id);

    //获取购物车中所有预购门票
    List<Ticket> queryCarts();

    //获取所有的景区新闻
    List<JQXW> jqxwsAll();

    //获取所有的景区新闻
    List<JQHD> jqhdsAll();

    //获取所有的景区新闻
    List<JQGG> jqggsAll();

}
