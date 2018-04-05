package com.codeup.adlister.controllers;
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
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            connection= DriverManager.getConnection(config.getUrl(),config.getUser(),config.getPassword());
            query = "SELECT username, password FROM users where username = ?;";
            authenticate = connection.prepareStatement(query);
            authenticate.setString(1,username);
            authenticate.executeQuery();
            ResultSet rs = authenticate.getResultSet();

//            while(rs.next()){
//                dbUsername = rs.getString("username");
//                dbPassword = rs.getString("password");
//
//                if(dbUsername.equals(username) && dbPassword.equals(password)){
//                    System.out.println("credentials matches database. All OK");
//                    login = true;
//                    break;
//                }
//                System.out.println(username + password + " " + dbUsername + dbPassword);
//            }
            rs.next();
            dbUsername = rs.getString("username");
            dbPassword = rs.getString("password");

            if(dbUsername.equals(username) && dbPassword.equals(password)){
                    System.out.println("credentials matches database. All OK");
                    login = true;
                }
            System.out.printf("%s %s, %s %s\n", username, password, dbUsername, dbPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(login);
        return login;
    }
}
