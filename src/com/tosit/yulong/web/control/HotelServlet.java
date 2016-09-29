package com.tosit.yulong.web.control;

import com.tosit.yulong.web.daoImp.DaoImpl;
import com.tosit.yulong.web.entity.Hotel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * Created by zx on 2016/9/26.
 */
@WebServlet("/HotelServlet")
public class HotelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("h_id");
//       System.out.println("HotelServlet 拿到了"+id);
        int h_id = Integer.parseInt(id);
        Hotel hotel = new DaoImpl().hotelByh_id(h_id);//当前hotel
        Hotel prevHotel = new Hotel();
        Hotel nextHotel = new Hotel();
//        System.out.println(hotel.getHotelId()+"丨"+hotel.getHotelName()+"|"+hotel.getDescription()+"丨"+hotel.getHotelImg());
        List<Hotel> hotels = new DaoImpl().hotelsAll();
        int len = hotels.size();
        //----------判断并获取上一个酒店---------------//
        if (h_id > 1 && h_id <= len) {
            prevHotel = hotels.get(h_id - 2);//获取上一个酒店
        } else if (h_id == 1) {
            prevHotel.setHotelId(h_id);
            prevHotel.setHotelName("空");
        }
        request.setAttribute("prevHotel", prevHotel);
        //----------判断并获取下一个酒店---------------//
        if (h_id < len && h_id >= 1) {
            nextHotel = hotels.get(h_id);//获取下一个酒店
        } else if (h_id == len) {
            nextHotel.setHotelId(h_id);
            nextHotel.setHotelName("空");
        }
        request.setAttribute("nextHotel", nextHotel);
        //---------------读取 TXT 文本----------------------\\
        String txturl = "D:/IdWorkSpace/yulong/web/txt" + hotel.getDescription();
        String txt = "";
        File file = new File(txturl);
        if (file.isFile() && file.exists()) {
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis, "utf-8");
            BufferedReader buffer = new BufferedReader(isr);
            String line = "";
            while ((line = buffer.readLine()) != null) {
                txt += line;
            }
            isr.close();
        } else {
            System.out.println("找不到指定的文件");
        }
        request.setAttribute("txt", txt);
        //---------------读取 TXT 文本----------------------\\
        request.setAttribute("hotel", hotel);
        request.getRequestDispatcher("/hotel.jsp").forward(request, response);
        //测试查看数据是否被传递成功
//        request.getRequestDispatcher("/com.test.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
