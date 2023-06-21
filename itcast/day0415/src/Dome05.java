import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

/**
 * author:Administrator
 * createTime:2023/4/1614:17
 */
public class Dome05 {
    public static void main(String[] args) {
        ArrayList<emp> list = new ArrayList<>();
        Connection conn = null;
        Statement stat = null;
        ResultSet emp = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/data2","root","jev123");
            stat = conn.createStatement();
            emp = stat.executeQuery("select * from emp");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
           if(emp != null){
               try {
                   emp.close();
               } catch (SQLException e) {
                   throw new RuntimeException(e);
               }
           }
            if(stat != null){
                try {
                    stat.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

        }

        for(emp e : list){
            System.out.println(e);
        }

    }
}
