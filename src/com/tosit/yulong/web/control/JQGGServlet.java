package com.tosit.yulong.web.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.tosit.yulong.web.entity.JQGG;

/**
 * 根据点击的公告id来动态展示
 */
@WebServlet("/jqgg")
public class JQGGServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		
		String id=req.getParameter("jqgg_id");
		int jqgg_id=Integer.parseInt(id);
		List<JQGG>jqggs=(List)this.getServletContext().getAttribute("jqggs");
		for (JQGG jqgg : jqggs) {
			if (jqgg.getId()==jqgg_id) {
				req.setAttribute("jqgg", jqgg);
			}
		}
		req.getRequestDispatcher("/activity.jsp").forward(req, resp);
	}

}
