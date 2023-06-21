package cn.itcast.druid;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * author:Administrator
 * createTime:2023/4/178:46
 */
public class JDBCUltiless {
    private static DataSource ds;
    static {
        try {//JDBCUltiless.class.getClassLoader().getResourceAsStream("druid.properties"
            Properties pro = new Properties();
            pro.load(JDBCUltiless.class.getClassLoader().getResourceAsStream("druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //获取datasource数据库连接池对象
    public static DataSource getDatasource() {
        try {
            return ds;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    //获取connection数据库链接对象
    public static Connection getConnection() {
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //释放资源
    public static void close(Connection conn, Statement stat, ResultSet res) {
        if (res != null) {
            try {
                res.close();
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
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void close(Connection conn, Statement stat) {
        close(conn, stat, null);
    }
}
