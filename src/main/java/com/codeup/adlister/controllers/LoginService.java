package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;

import java.sql.*;

public class LoginService {

    public boolean authenticate (String username, String password){
        String query;
        String dbUsername, dbPassword;
        boolean login = false;
        Config config = new Config();
        Connection connection = null;
        PreparedStatement authenticate = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection(config.getUrl(),config.getUser(),config.getPassword());
            query = "SELECT username, password FROM users;";
            authenticate = connection.prepareStatement(query);
            authenticate.executeQuery();
            ResultSet rs = authenticate.getResultSet();

            while(rs.next()){
                dbUsername = rs.getString("username");
                dbPassword = rs.getString("password");

                if(dbUsername.equals(username) && dbPassword.equals(password)){
                    System.out.println("OK");
                    login = true;
                }
                System.out.println(username + password + " " + dbUsername + dbPassword);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return login;
    }

}
