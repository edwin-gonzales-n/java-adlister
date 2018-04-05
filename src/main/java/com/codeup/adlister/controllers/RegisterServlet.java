package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String  username = request.getParameter("username"),
                password = request.getParameter("password"),
                password_confirm = request.getParameter("password_confirm"),
                email = request.getParameter("email");
        HttpSession session = request.getSession();

        if (password == null || password.trim() == ""){
            session.removeAttribute("password_error");
            session.removeAttribute("email_error");
            session.removeAttribute("username_error");
            session.removeAttribute("password_mismatch");
            session.setAttribute("password_error",  "<p style=\"color:red\">Sorry \"password\" error!</p>");
            response.sendRedirect("/register");
        } else if(!password.equals(password_confirm)){
            session.removeAttribute("password_error");
            session.removeAttribute("email_error");
            session.removeAttribute("username_error");
            session.removeAttribute("password_mismatch");
            session.setAttribute("password_mismatch",  "<p style=\"color:red\">Sorry \"passwords\" do not match!</p>");
            response.sendRedirect("/register");
        }
        else if (email == null || email.trim() == ""){
            session.removeAttribute("password_error");
            session.removeAttribute("email_error");
            session.removeAttribute("username_error");
            session.removeAttribute("password_mismatch");
            session.setAttribute("email_error",  "<p style=\"color:red\">Sorry \"email\" error!</p>");
            response.sendRedirect("/register");
        } else if (username == null || username.trim() == ""){
            session.removeAttribute("password_error");
            session.removeAttribute("email_error");
            session.removeAttribute("username_error");
            session.removeAttribute("password_mismatch");
            session.setAttribute("username_error",  "<p style=\"color:red\">Sorry \"username\" error!</p>");
            response.sendRedirect("/register");
        } else {
            session.removeAttribute("password_error");
            session.removeAttribute("password_mismatch");
            session.removeAttribute("email_error");
            session.removeAttribute("username_error");
            session.setAttribute("username", username);
            session.setAttribute("password", password);
            session.setAttribute("email", email);
            User user = new User(
                    1,
                    request.getParameter("username"),
                    request.getParameter("email"),
                    request.getParameter("password")
            );
            DaoFactory.getUsersDao().insert(user);
            response.sendRedirect("/profile");
        }

    }
}
