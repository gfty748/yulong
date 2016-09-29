package test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by zx on 2016/9/26.
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String txturl = getServletContext().getRealPath("hfhg.txt");
        String txturl ="D:/IdWorkSpace/yulong/web/txt/hfhg.txt";
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
        }else {
            System.out.println("找不到指定的文件");
        }
        request.setAttribute("txt", txt);
        request.getRequestDispatcher("com.test.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
