package com.mk.Dao;

import com.mk.Entity.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public class UserDao {

    @Resource
    private JdbcTemplate jdbcTemplate;

    public List<User> getAllUser(){
        String sql = "SELECT * FROM users";
        List<User> userList = jdbcTemplate.query(sql, new RowMapper<User>() {
            User user= null;
            @Override
            public User mapRow(ResultSet rs, int i) throws SQLException {
                user = new User();
                user.setId(rs.getString("id"));
                user.setFirst_name(rs.getString("first_name"));
                user.setLast_name(rs.getString("last_name"));
                user.setGender(rs.getString("gender"));
                user.setDate_of_birth(rs.getString("date_of_birth"));
                user.setEmail(rs.getString("email"));
                return user;
            }
        });
        return userList;
    }

    public List<User> getUserById(String id){
        String sql = "SELECT * FROM users WHERE id= '"+id+"'";
        List<User> userList = jdbcTemplate.query(sql, new RowMapper<User>() {
            User user= null;
            @Override
            public User mapRow(ResultSet rs, int i) throws SQLException {
                user = new User();
                user.setId(rs.getString("id"));
                user.setFirst_name(rs.getString("first_name"));
                user.setLast_name(rs.getString("last_name"));
                user.setGender(rs.getString("gender"));
                user.setDate_of_birth(rs.getString("date_of_birth"));
                user.setEmail(rs.getString("email"));
                return user;
            }
        });
        return userList;

    }

    public String addUser(User user){
        String sql = "INSERT INTO users(id,first_name,last_name,gender, date_of_birth, email) VALUES (?, ?, ?, ?, ?, ?)";
        /*
        need to convert String to Date type so the database can recognize.
         */
        jdbcTemplate.update(sql,java.util.UUID.fromString(user.getId()),user.getFirst_name(),user.getLast_name(),user.getGender(),java.sql.Date.valueOf(user.getDate_of_birth()),user.getEmail());
        return "User "+user.getFirst_name()+" "+user.getLast_name()+" added";

    }

    public String removeUser(String id){
        String sql = "DELETE FROM users WHERE id = ?";
        jdbcTemplate.update(sql,java.util.UUID.fromString(id));
        return "User "+id+" removed";
    }
}
