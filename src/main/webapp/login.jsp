<%--
  Created by IntelliJ IDEA.
  User: Gonzo
  Date: 3/26/18
  Time: 4:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.io.*,java.util.*"%>
<%@ include file="partials/welcome-message.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
String username = request.getParameter("username");
String password = request.getParameter("password");

    if(username == null && password == null){
        username = "user";
    }

    assert username != null;
    if(username.equals("admin") && password.equals("password")){
        response.sendRedirect("profile.jsp");
    }
%>

<html>
<head>
    <title>Login</title>
</head>
<body>
    <div style="text-align: center;">
        <form method="post" action="login.jsp">
            <b>LOGIN :</b>
            <input type="text" name="username" placeholder="please type your email" width="20">
            <label>
                <input type="password" name="password">
            </label>
            <button type="submit">Login</button>
        </form>

    </div>
</body>
</html>
