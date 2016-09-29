package com.tosit.yulong.web.control;

import com.tosit.yulong.web.daoImp.DaoImpl;
import com.tosit.yulong.web.entity.Ticket;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Administrator on 2016/9/29 0029.
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        int id = Integer.parseInt(request.getParameter("t_id"));
        System.out.println("CartServlet 拿到了 id = " + id );
        Ticket ticket = new DaoImpl().ticketByt_id(id);
        int c_id = ticket.getT_id();
        String c_name = ticket.getT_name();
        int c_price = ticket.getT_price();
        List<Ticket> tickets = new DaoImpl().queryCarts();
        boolean isHas = false;
        String message = "";
        for (Ticket tEach: tickets ) {
            if (tEach.getT_id() == id){
                isHas = true;
                out.print("购物车已经存在此票！");
                return;
            }
        }
        if (!isHas){
            new DaoImpl().addCartByt_id(c_id,c_name,c_price);
            out.print("成功加入购物车！");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }


}
