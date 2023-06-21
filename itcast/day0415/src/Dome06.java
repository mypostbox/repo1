import util.JDBCUtils;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

/**
 * author:Administrator
 * createTime:2023/4/1614:53
 */
public class Dome06 {
    public static void main(String[] args) throws SQLException {
        ArrayList<emp> list = new ArrayList<>();
        Connection conn = JDBCUtils.getConnection();
        Statement stat = conn.createStatement();
        ResultSet rest = stat.executeQuery("select * from emp");
        while (rest.next()) {
            int id = rest.getInt("id");
            String ename = rest.getString("ename");
            int jobId = rest.getInt("job_id");
            int mgr = rest.getInt("mgr");
            Date joindate = rest.getDate("joindate");
            BigDecimal salary = rest.getBigDecimal("salary");
            BigDecimal bonus = rest.getBigDecimal("bonus");
            int deptId = rest.getInt("dept_id");
//            list.add(new emp(id, ename, jobId, mgr, joindate, salary, bonus, deptId));
        }
        JDBCUtils.UtilClose(conn,stat, rest);
        for (emp e : list) {
            System.out.println(e);
        }
    }
}
