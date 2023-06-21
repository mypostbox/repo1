import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * author:${USER}
 * createTime:${DATE}${TIME}
 */
public class Main {
    public static void main(String[] args) throws Exception {
        //1.导入架包
        //2.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //3.获取数据库连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/data2", "root", "jev123");
        //4.定义sql语句
        String sql = "update emp set salary = 5000 where id=1001";
        //5.获取执行sql的对象
        Statement stmt = conn.createStatement();
        //6.执行sql
        int i = stmt.executeUpdate(sql);
        //7 处理结果
        System.out.println(i);
        //8 释放资源
        stmt.close();
        conn.close();
    }
}