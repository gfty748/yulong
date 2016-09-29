package com.tosit.yulong.web.Utils;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by zx on 2016/9/25.
 */
public class DBUtil {
    private String url ="jdbc:mysql://192.168.1.116:3306/yulong";
    private String username ="root";
    private String password ="root";
    Connection conn;
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public Connection ConnectionDB(){
        try {
            conn = DriverManager.getConnection(url,username,password);
            return  conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
