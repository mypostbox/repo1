import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * author:Administrator
 * createTime:2023/4/1516:51
 */
public class Dome02 {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/data1","root","jev123");

        Statement stat = conn.createStatement();

        int i = stat.executeUpdate("insert into emp values(3,'tom',3)");

        int i1 = stat.executeUpdate("update emp set name = 'lis4' where eid=1");

        int i2 = stat.executeUpdate("delete from emp where eid=2");

        System.out.println(i);
        System.out.println(i1);
        System.out.println(i2);

        stat.close();
        conn.close();
    }
}
