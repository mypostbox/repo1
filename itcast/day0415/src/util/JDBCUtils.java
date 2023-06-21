package util;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * author:Administrator
 * createTime:2023/4/1520:33
 */
public class JDBCUtils {
    private static final String url;
    private static final String user;
    private static final String password;

    //效仿驱动静态加载配置文件
    static {
        Properties pro = new Properties();
        try {
            pro.load(JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties"));
            //配置文件的绝对路径（URL的path方法）
           // System.out.println(JDBCUtils.class.getClassLoader().getResource("jdbc.properties").getPath());
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //获取连接对象
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //释放DDL,DML对象资源
    public static void UtilClose(Connection conn, Statement stat) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (stat != null) {
            try {
                stat.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    //释放DDL,DML,DQL对象
    public static void UtilClose(Connection conn, Statement stat, ResultSet res) {
        if (res != null) {
            try {
                res.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        if (stat != null) {
            try {
                stat.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
