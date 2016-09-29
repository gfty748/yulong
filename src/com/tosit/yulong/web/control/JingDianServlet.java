package com.tosit.yulong.web.control;

import com.tosit.yulong.web.daoImp.DaoImpl;
import com.tosit.yulong.web.entity.JingDian;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * Created by zx on 2016/9/27.
 */
@WebServlet("/JingDianServlet")
public class JingDianServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<JingDian> jingDianList = new DaoImpl().jdsAll();
        for (JingDian jd : jingDianList) {
            //---------------读取 TXT 文本----------------------\\
            String txturl = "D:/IdWorkSpace/yulong/web/txt" + jd.getJd_description();
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
            jd.setJd_description(txt);
        }
        request.setAttribute("jds", jingDianList);
        request.getRequestDispatcher("/com.test.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
