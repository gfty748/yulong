package com.tosit.yulong.web.control;

import com.tosit.yulong.web.daoImp.DaoImpl;
import com.tosit.yulong.web.entity.Route;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * 路线Servlet
 */
@WebServlet("/RoutesServlet")
public class RoutesServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Route> routeList = new DaoImpl().routesAll();//获取所有线路
        int len = routeList.size();//线路的个数
        //--------------- 遍历 读取 TXT 文本 begin----------------------\\
        for (Route rEach : routeList) {
            String txturl = "D:/IdWorkSpace/yulong/web/txt" + rEach.getR_description();
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
            rEach.setR_description(txt);
        }
        //--------------- 遍历 读取 TXT 文本 end ----------------------\\

        request.setAttribute("routes",routeList);
        request.getRequestDispatcher("/routes.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
