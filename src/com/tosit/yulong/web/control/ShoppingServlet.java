package com.tosit.yulong.web.control;

import com.tosit.yulong.web.Utils.DDHUtil;
import com.tosit.yulong.web.Utils.JSUtil;
import com.tosit.yulong.web.daoImp.DaoImpl;
import com.tosit.yulong.web.entity.Oder;
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
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        DDHUtil DDH = new DDHUtil();
        //获取购物车信息
        List<Ticket> tickets = new DaoImpl().queryCarts();
        request.setAttribute("tickets",tickets);
        int total = new JSUtil().getTotal();
        request.setAttribute("total",total);
        String http=request.getParameter("http");

        if (http.equals("orders")){
            request.getRequestDispatcher("/shoppingCartOrders.jsp").forward(request,response);
        }else if(http.equals("cart")){
            request.getRequestDispatcher("/shoppingCart.jsp").forward(request,response);
        }else if(http.equals("buy")){
            String name = request.getParameter("username");
            String phone =request.getParameter("phone");
            String certificate =request.getParameter("certificate");
            String goods="购买了：";
            for (Ticket tEach:tickets) {
                goods+= tEach.getT_name()+" "+tEach.getT_number()+"张|";
            }
            System.out.println("拿到了 http= "+http+"| name " +name);
            String ddh = DDH.getDDH(name);
            new DaoImpl().addOder(ddh,name,phone,certificate,goods,total);
            new DaoImpl().delCartAll();
            String message = "预定成功!";
            request.setAttribute("name",name);
            request.setAttribute("ddh",ddh);
            request.setAttribute("message",message);
            request.getRequestDispatcher("/shoppingSuccess.jsp").forward(request,response);
        }else if (http.equals("query")){
            String id = request.getParameter("id");
            System.out.println("执行Query()，id = "+id);
            List<Oder> oders = new DaoImpl().odersQuery(id);
            request.setAttribute("oders",oders);
            request.getRequestDispatcher("/queryOrder.jsp").forward(request,response);
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
