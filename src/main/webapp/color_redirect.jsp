<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: Gonzo
  Date: 3/28/18
  Time: 10:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>

<%
    String title = "Your favorite color is: ";
    String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
    response.setContentType("text/html");
    PrintWriter pw=response.getWriter();
    String userColor=request.getParameter("mycolor");

    pw.printf("%s\n%s%s%s\n%s bgcolor = \"%s\">\n" +
            "<h1 align = \"center\">%s</h1>\n" +
            "<h2 align =\"center\" Style=\"color: white\">%s</h2>\n",
            docType,"<title>", title,"</title>","<body", userColor,title,userColor);
%>

</html>
