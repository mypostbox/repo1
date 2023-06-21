import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * author:Administrator
 * createTime:2023/4/1517:23
 */
public class Dome03 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stat = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/data1", "root", "jev123");
            stat = conn.createStatement();
            int i = stat.executeUpdate("insert into emp values(null,'wang5',3)");
            System.out.println(i);
            if (i > 0) {
                System.out.println("执行成功");
            } else {
                System.out.println("执行失败");
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (conn != null) {
                try {
                    stat.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
