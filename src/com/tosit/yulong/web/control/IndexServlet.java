package com.tosit.yulong.web.control;

import com.tosit.yulong.web.daoImp.DaoImpl;
import com.tosit.yulong.web.entity.JQGG;
import com.tosit.yulong.web.entity.JQHD;
import com.tosit.yulong.web.entity.JQXW;
import com.tosit.yulong.web.entity.WenZhang;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by zx on 2016/9/26.
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoImpl wzdi = new DaoImpl();

        List<JQXW>jqxws=wzdi.jqxwsAll();
        List<JQHD>jqhds=wzdi.jqhdsAll();
        List<JQGG>jqggs=wzdi.jqggsAll();

        List<WenZhang> wenZhangBylm_id4 = wzdi.wenZhangBylm_id(4);
        List<WenZhang> wenZhangBylm_id5 = wzdi.wenZhangBylm_id(5);
        List<WenZhang> wenZhangBylm_id6 = wzdi.wenZhangBylm_id(6);
        List<WenZhang> wenZhangBylm_id7 = wzdi.wenZhangBylm_id(7);

//        Map<String,List<WenZhang>> indexMap = new HashMap<String,List<WenZhang>>();

        this.getServletContext().setAttribute("jqxws",jqxws);
        this.getServletContext().setAttribute("jqhds",jqhds);
        this.getServletContext().setAttribute("jqggs",jqggs);

        request.setAttribute("wenZhangBylm_id4", wenZhangBylm_id4);
        request.setAttribute("wenZhangBylm_id5", wenZhangBylm_id5);
        request.setAttribute("wenZhangBylm_id7", wenZhangBylm_id7);
        request.setAttribute("wenZhangBylm_id6", wenZhangBylm_id6);



//        request.setAttribute("indexMap",indexMap);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
//        System.out.println(wenZhangBylm_id6.size());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}


