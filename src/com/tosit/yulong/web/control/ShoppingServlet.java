package com.tosit.yulong.web.control;

import com.tosit.yulong.web.Utils.JSUtil;
import com.tosit.yulong.web.daoImp.DaoImpl;
import com.tosit.yulong.web.entity.Ticket;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2016/9/29 0029.
 */
@WebServlet( "/ShoppingServlet")
public class ShoppingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取购物车信息
        List<Ticket> tickets = new DaoImpl().queryCarts();
        request.setAttribute("tickets",tickets);
        int total = new JSUtil().getTotal();
        request.setAttribute("total",total);
        request.getRequestDispatcher("/shoppingCart.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
