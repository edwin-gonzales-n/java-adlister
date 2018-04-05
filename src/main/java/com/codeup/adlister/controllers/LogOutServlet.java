package com.codeup.adlister.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LogOutServlet", urlPatterns = "/logout")
public class LogOutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().removeAttribute("user");
        request.getSession().removeAttribute("login_error");
        request.removeAttribute("password_error");
        request.removeAttribute("email_error");
        request.removeAttribute("username_error");
        request.removeAttribute("password_mismatch");
        request.getSession().invalidate();
        response.sendRedirect("/login");
    }
}
