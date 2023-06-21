import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

/**
 * author:${USER}
 * createTime:${DATE}${TIME}
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        ArrayList<emp> list = new ArrayList<>();
        DataSource ds = new ComboPooledDataSource();
        Connection conn = ds.getConnection();
        Statement stat = conn.createStatement();
        String sql = "select * from emp";
        ResultSet res = stat.executeQuery(sql);
        while (res.next()){
            int id = res.getInt("id");
            String ename = res.getString("ename");
            int jobId = res.getInt("job_id");
            int mgr = res.getInt("mgr");
            Date joindate = res.getDate("joindate");
            Double salary = res.getDouble("salary");
            Double bonus = res.getDouble("bonus");
            int deptId = res.getInt("dept_id");
           list.add(new emp(id, ename, jobId, mgr, joindate, salary, bonus, deptId));
        }

        stat.close();
        conn.close();
        for(emp e : list){
            System.out.println(e);
        }
    }
}