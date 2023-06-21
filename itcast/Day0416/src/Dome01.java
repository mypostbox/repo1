import cn.itcast.druid.JDBCUltiless;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * author:Administrator
 * createTime:2023/4/1716:38
 */
public class Dome01 {
    public static void main(String[] args) throws SQLException {

       /* List<sut> list = new ArrayList<>();
        Connection conn = JDBCUltiless.getConnection();
        Statement stat = conn.createStatement();
        ResultSet res = stat.executeQuery("select * from sut");
        while (res.next()){
            int id = res.getInt("id");
            String name = res.getString("name");
            list.add(new sut(id,name));
        }
        JDBCUltiless.close(conn,stat,res);
*/
        System.out.println("------------");
        JdbcTemplate template = new JdbcTemplate(JDBCUltiless.getDatasource());

//        int update = template.update("select * from sut", new BeanPropertyRowMapper<sut>(sut.class));
        List<sut> list = template.query("select * from sut", new BeanPropertyRowMapper<sut>(sut.class));

        for(sut s : list){
            System.out.println(s);
        }

    }
}
