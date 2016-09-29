package com.tosit.yulong.web.control;

import com.tosit.yulong.web.daoImp.DaoImpl;
import com.tosit.yulong.web.entity.JingDian;
import com.tosit.yulong.web.entity.Route;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 *路线Servlet
 */
@WebServlet("/RouteServlet")
public class RouteServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("r_id"));
        System.out.println("RouteServlet 拿到了 " + id);
        Route route = new DaoImpl().routeByr_id(id);
        //---------------   读取 TXT 文本 begin----------------------\\
        String txturl = "D:/IdWorkSpace/yulong/web/txt" + route.getR_description();
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
        route.setR_description(txt);
        //--------------- 读取 TXT 文本 end----------------------\\
        request.setAttribute("route",route);
        request.getRequestDispatcher("/route.jsp").forward(request,response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }

}
