package com.codeup.adlister.dao;

import com.codeup.adlister.controllers.Config;
import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySQLUsersDao implements Users{
    private Connection connection = null;
    private PreparedStatement findUserName = null;
    private PreparedStatement insertUser = null;

    public MySQLUsersDao(Config config) {
        try{
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e){
            throw new RuntimeException("Error connecting to the database!", e);
        }
    }


    @Override
    public User findByUsername(String user) {
        try{
            findUserName= connection.prepareStatement("select * from users where username = ?");

            findUserName.setString(1,user);
            ResultSet rs = findUserName.executeQuery();

            return  extractUser(rs);

        } catch (SQLException e) {
            throw new RuntimeException("Error accessing DB.", e);
        }
    }

    private User extractUser(ResultSet rs) throws SQLException{
        return new User(
                rs.getLong("id"),
                rs.getString("username"),
                rs.getString("password"),
                rs.getString("email")
        );
    }

    private List<User> createUsersFromResults(ResultSet rs) throws SQLException{
        List<User> users = new ArrayList<>();
        while (rs.next()){
            users.add(extractUser(rs));
        }
        return users;
    }


    @Override
    public Long insert(User user) {
        try {
            insertUser = connection.prepareStatement(createInsertQuery(user), Statement.RETURN_GENERATED_KEYS);

            insertUser.setString(1,user.getUsername());
            insertUser.setString(2,user.getEmail());
            insertUser.setString(3,user.getPassword());
            insertUser.executeUpdate();

            ResultSet rs = insertUser.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);
        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    private String createInsertQuery(User user){
        return "insert into users(username,password,email) values(?,?,?)";
    }
}
