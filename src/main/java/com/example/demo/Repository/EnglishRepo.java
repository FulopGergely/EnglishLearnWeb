package com.example.demo.Repository;

import com.example.demo.Domain.English;
import com.example.demo.Domain.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class EnglishRepo {

    private JdbcTemplate jdbc;

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Test> findAllTest() {
        String sql =  "select * from test";
        return jdbc.query( sql , (rs,i) -> new Test(
                rs.getString("TestID"),
                rs.getString("test"),
                rs.getString("name"),
                rs.getString("score"),
                rs.getString("tipp"),
                rs.getDate("dates")
        ));
    }

    public List<English> findAll() {
        String sql = "select * from english";
        return jdbc.query( sql , (rs,i) -> new English(
           rs.getString("question"),
           rs.getString("answer1"),
           rs.getString("answer2"),
           rs.getString("answer3"),
           rs.getString("correct"),
           rs.getString("type"),
           rs.getString("test"),
           rs.getString("id")
        ));
    }

    public void insert(Test test)
    {
        String sql = "INSERT INTO TEST(test, name, score, tipp, dates) VALUES (?, ?, ?, ?, ?)";
        jdbc.update(new PreparedStatementCreator()
        {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection)
                    throws SQLException
            {
                PreparedStatement ps = connection.prepareStatement(sql,
                        Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, test.getTest());
                ps.setString(2, test.getName());
                ps.setString(3, test.getScore());
                ps.setString(4, test.getTipp());
                ps.setDate(5, test.getDates());
                return ps;
            }
        });

    }

    /*

*/

}
