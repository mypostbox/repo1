import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * author:Administrator
 * createTime:2023/4/1515:40
 */
public class Dome01 {
    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = new com.mysql.cj.jdbc.Driver();
        DriverManager.registerDriver(driver);

        Connection con = DriverManager.getConnection("jdbc:mysql:///data2", "root", "jev123");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306:/data2");


        Statement statement = con.createStatement();

        con.setAutoCommit(false);
        con.commit();
        con.rollback();


    }
}
