package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.MySQLUsersDao;
import com.codeup.adlister.dao.Users;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "controllers.LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Users usersDao = DaoFactory.getUsersDao();
        User user = usersDao.findByUsername(username);
        boolean authenticated = usersDao.VerifyPassword(username,password);
        HttpSession session = request.getSession();

        if (user == null) {
            response.sendRedirect("/login");
            session.removeAttribute("password_error");
            session.setAttribute("username_error",  "<p style=\"color:red\">Sorry \"wrong username\"!</p>");
            return;
        }

//        boolean validAttempt = password.equals(user.getPassword());

        if (authenticated) {
            request.getSession().setAttribute("user", user);
            response.sendRedirect("/profile");
        } else {
            session.removeAttribute("username_error");
            session.setAttribute("password_error",  "<p style=\"color:red\">Sorry \"wrong password\"!</p>");
            response.sendRedirect("/login");
        }
    }
}
