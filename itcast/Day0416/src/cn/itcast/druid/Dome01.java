package cn.itcast.druid;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * author:Administrator
 * createTime:2023/4/1710:12
 */
public class Dome01 {
    public static void main(String[] args) {
        JdbcTemplate template = new JdbcTemplate(JDBCUltiless.getDatasource());
        String sql1 = "select * from emp";

        List<emp> query = template.query(sql1, new BeanPropertyRowMapper<emp>(emp.class));

      /*  List<emp> query = template.query(sql1, new RowMapper<emp>() {
            @Override
            public emp mapRow(ResultSet resultSet, int i) throws SQLException {
                int id = resultSet.getInt("id");
                String ename = resultSet.getString("ename");
                int jobId = resultSet.getInt("job_id");
                int mgr = resultSet.getInt("mgr");
                Date joindate = resultSet.getDate("joindate");
                double salary = resultSet.getDouble("salary");
                double bonus = resultSet.getDouble("bonus");
                int deptId = resultSet.getInt("dept_id");
                return new emp(id, ename, jobId, mgr, joindate, salary, bonus, deptId);
            }
        });*/




        for (emp e : query) {
            System.out.println(e);
        }


       /* String sql2 = "update emp set salary=? where id = ?";
        int li4 = template.update(sql2,8000,1001);
        System.out.println(li4);*/
    }
}
