package com.tosit.yulong.web.daoImp;

import com.tosit.yulong.web.Utils.DBUtil;
import com.tosit.yulong.web.dao.Dao;
import com.tosit.yulong.web.entity.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zx on 2016/9/26.
 */
public class DaoImpl implements Dao {
    Connection conn = new DBUtil().ConnectionDB();
    String MySql;

    @Override
    public List<LanMu> querryAll() {
        List<LanMu> lanmuList = new ArrayList<LanMu>();
        MySql = "SELECT * from lanmu";
        try {
            PreparedStatement pstmt = conn.prepareStatement(MySql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                lanmuList.add(new LanMu(rs.getInt("lm_id"), rs.getString("lm_name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lanmuList;
    }

    //    @Override
//    public void querryByID(int lm_id, int wz_id) {
//
//    }
    @Override
    public List<WenZhang> queryALL() {
        List<WenZhang> wenZhangList = new ArrayList<WenZhang>();
        MySql = "SELECT * from wenzhang";
        try {
            PreparedStatement pmtst = conn.prepareStatement(MySql);
            ResultSet rs = pmtst.executeQuery();
            while (rs.next()) {
                wenZhangList.add(new WenZhang(rs.getInt("wz_id"), rs.getString("wz_title"), rs.getString("wz_content"), rs.getString("wz_img")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return wenZhangList;
    }

    @Override
    public List<WenZhang> wenZhangBylm_id(int lm_id) {
        List<WenZhang> wenZhangBylm_idByList = new ArrayList<WenZhang>();
        MySql = "SELECT * from wenzhang where lm_id = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(MySql);
            int i = 1;
            pstmt.setInt(i++, lm_id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                wenZhangBylm_idByList.add(new WenZhang(rs.getInt("wz_id"), rs.getString("wz_title"), rs.getString("wz_content"), rs.getString("wz_img")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return wenZhangBylm_idByList;
    }

    @Override
    public Hotel hotelByh_id(int h_ids) {
        Hotel hotel = new Hotel();
        MySql = "SELECT * from hotel WHERE h_id = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(MySql);
            int i = 1;
            pstmt.setInt(i++, h_ids);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int h_id = rs.getInt("h_id");
                String h_name = rs.getString("h_name");
                String h_description = rs.getString("h_description");
                String h_img = rs.getString("h_img");
                hotel = new Hotel(h_id, h_name, h_description, h_img);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hotel;
    }

    @Override
    public List<Hotel> hotelsAll() {
        List<Hotel> hotels = new ArrayList<Hotel>();
        Hotel hotel = new Hotel();
        MySql = "SELECT * FROM hotel";
        try {
            PreparedStatement pstmt = conn.prepareStatement(MySql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int h_id = rs.getInt("h_id");
                String h_name = rs.getString("h_name");
                String h_description = rs.getString("h_description");
                String h_img = rs.getString("h_img");
                hotel = new Hotel(h_id, h_name, h_description, h_img);
                hotels.add(hotel);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hotels;
    }

    @Override
    public JingDian jdByjd_id(int jd_id) {
        return null;
    }

    @Override
    public List<JingDian> jdsAll() {
        List<JingDian> jingDianList = new ArrayList<>();
        MySql = "select * from jingdian";
        try {
            PreparedStatement pstmt = conn.prepareStatement(MySql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int jd_id = rs.getInt("jd_id");
                String jd_name = rs.getString("jd_name");
                String jd_description = rs.getString("jd_description");
                String jd_img = rs.getString("jd_img");
                jingDianList.add(new JingDian(jd_id, jd_name, jd_description, jd_img));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jingDianList;
    }

    @Override
    public Route routeByr_id(int id) {
        Route route = new Route();
        MySql = "select * from route WHERE r_id = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(MySql);
            int i = 1;
            pstmt.setInt(i++, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int r_id = rs.getInt("r_id");
                String r_name = rs.getString("r_name");
                String r_description = rs.getString("r_description");
                String r_img = rs.getString("r_img");
                route = new Route(r_id, r_name, r_description, r_img);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return route;
    }

    @Override
    public List<Route> routesAll() {
        List<Route> routeList = new ArrayList<>();
        MySql = "select * from route";
        try {
            PreparedStatement pstmt = conn.prepareStatement(MySql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int r_id = rs.getInt("r_id");
                String r_name = rs.getString("r_name");
                String r_description = rs.getString("r_description");
                String r_img = rs.getString("r_img");
                routeList.add(new Route(r_id, r_name, r_description, r_img));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return routeList;
    }

    /**
     * 获取所有门票
     *
     * @return
     */
    @Override
    public List<Ticket> ticketsAll() {
        List<Ticket> tickets = new ArrayList<>();
        MySql = "Select * from ticket";
        try {
            PreparedStatement pstmt = conn.prepareStatement(MySql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int t_id = rs.getInt("t_id");
                String t_name = rs.getString("t_name");
                String t_description = rs.getString("t_description");
                String t_img = rs.getString("t_img");
                int t_price = rs.getInt("t_price");
                tickets.add(new Ticket(t_id, t_name, t_description, t_img, t_price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tickets;
    }

    /**
     * 获取指定门票
     *
     * @return
     */
    @Override
    public Ticket ticketByt_id(int id) {
        Ticket ticket = new Ticket();
        MySql = "select * from ticket WHERE t_id = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(MySql);
            int i = 1;
            pstmt.setInt(i++, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int t_id = rs.getInt("t_id");
                String t_name = rs.getString("t_name");
                String t_description = rs.getString("t_description");
                String t_img = rs.getString("t_img");
                int t_price = rs.getInt("t_price");
                ticket = new Ticket(t_id, t_name, t_description, t_img, t_price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ticket;
    }

    @Override
    public void addCartByt_id(int t_id, String t_name, int t_price) {
        MySql = "insert into cart(c_id,c_name,c_price) values(?,?,?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(MySql);
            int i = 1;
            pstmt.setInt(i++, t_id);
            pstmt.setString(i++, t_name);
            pstmt.setInt(i++, t_price);
            int count = pstmt.executeUpdate();
            System.out.println("所有影响行数:" + count);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delCartByt_id(int t_id) {
        MySql = "delete from cart where c_id = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(MySql);
            int i = 1;
            pstmt.setInt(i++, t_id);
            int count = pstmt.executeUpdate();
            System.out.println("所有影响行数:" + count);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Ticket> queryCarts() {
        List<Ticket> tickets = new ArrayList<>();
        Ticket ticket = new Ticket();
        MySql = "select * from cart";
        try {
            PreparedStatement pstmt = conn.prepareStatement(MySql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int c_id = rs.getInt("c_id");
                String c_name = rs.getString("c_name");
                int c_price = rs.getInt("c_price");
                int c_number = rs.getInt("c_number");
                ticket = new Ticket(c_id, c_name, c_price, c_number);
                tickets.add(ticket);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tickets;
    }

    /**
     * 改变购物车的门票个数
     *
     * @param c_id
     */
    @Override
    public void updateC_number(int c_id, int c_number) {
        MySql = "UPDATE cart SET c_number = ? where c_id = ?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(MySql);
            int i = 1;
            pstmt.setInt(i++, c_number);
            pstmt.setInt(i++, c_id);
            int count = pstmt.executeUpdate();
            System.out.println("所有影响行数:" + count);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<JQXW> jqxwsAll() {
        List<JQXW> jqxws = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from wenzhang where lm_id=1");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                jqxws.add(new JQXW(rs.getInt("wz_id"), rs.getString("wz_title"), rs.getString("wz_content"), rs.getString("wz_time"), rs.getString("wz_img")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jqxws;
    }

    @Override
    public List<JQHD> jqhdsAll() {
        List<JQHD> jqhds = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from wenzhang where lm_id=3");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                jqhds.add(new JQHD(rs.getInt("wz_id"), rs.getString("wz_title"), rs.getString("wz_content"), rs.getString("wz_time"), rs.getString("wz_img")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jqhds;
    }

    @Override
    public List<JQGG> jqggsAll() {
        List<JQGG> jqggs = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from wenzhang where lm_id=2");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                jqggs.add(new JQGG(rs.getInt("wz_id"), rs.getString("wz_title"), rs.getString("wz_content"), rs.getString("wz_time"), rs.getString("wz_img")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jqggs;
    }


    /**
     * 获取购物车中所有门票
     *
     * @param args
     */


    //测试是否获取到数据库数据
    public static void main(String[] args) {
//       Route route = new DaoImpl().routeByr_id(2);
//       System.out.println(route.getR_id() + "丨" + route.getR_description());
//       Ticket ticket = new DaoImpl().ticketByt_id(1);
//       System.out.println(ticket.getT_id()+"|"+ticket.getT_name());
//       List<Ticket> tickets = new DaoImpl().queryCarts();
//       for (Ticket tEach:tickets
//               ) {
//           System.out.println(tEach.getT_id());
//       }
    }
}
