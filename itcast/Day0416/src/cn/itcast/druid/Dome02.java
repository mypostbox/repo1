package cn.itcast.druid;

import java.sql.*;
import java.util.ArrayList;

/**
 * author:Administrator
 * createTime:2023/4/1714:38
 */
public class Dome02 {
    public static void main(String[] args) {
        ArrayList<emp> list = new ArrayList<>();
        Connection conn = JDBCUltiless.getConnection();
        if(conn == null){
            System.out.println("------conn----!!!------");
        }
        String sql = "select * from emp";
        try {
            PreparedStatement pstat = conn.prepareStatement(sql);
            if(pstat == null){
                System.out.println("--------pstat--!!!-------");
            }

            ResultSet res = pstat.executeQuery();
            if(res == null){
                System.out.println("--------res----!!!--------");
            }

            while (res.next()) {
                int id = res.getInt("id");
                String ename = res.getString("ename");
                int jobId = res.getInt("job_id");
                int mgr = res.getInt("mgr");
                Date joindate = res.getDate("joindate");
                double salary = res.getDouble("salary");
                double bonus = res.getDouble("bonus");
                int deptId = res.getInt("dept_id");
                list.add(new emp(id, ename, jobId, mgr, joindate, salary, bonus, deptId));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        for(emp  e : list){
            System.out.println(e);
        }

    }
}
