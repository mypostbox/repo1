import util.JDBCUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * author:Administrator
 * createTime:2023/4/1615:43
 */
public class Dome07 {
    public static void main(String[] args) {
        ArrayList<String> name = new ArrayList<>();
        ArrayList<String> password = new ArrayList<>();
        Connection conn = JDBCUtils.getConnection();
        Statement stat = null;
        ResultSet result = null;
        try {
            stat = conn.createStatement();
            result = stat.executeQuery("select * from user");
            while (result.next()) {
                String uname = result.getString("uname");
                String upassword = result.getString("upassword");
                name.add(uname);
                password.add(upassword);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtils.UtilClose(conn, stat, result);
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String nameu = sc.next();
        System.out.println("请输入密码");
        String passwordu = sc.next();
        if (name.contains(nameu) && password.contains(passwordu)) {
            System.out.println("登入成功");
        } else {
            System.out.println("登入失败");
        }



    }
}

