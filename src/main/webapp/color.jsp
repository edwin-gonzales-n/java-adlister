<%--
  Created by IntelliJ IDEA.
  User: Gonzo
  Date: 3/28/18
  Time: 10:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
String colorname = request.getParameter("mycolor");

if(colorname== null){
colorname = "blank";
}
%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="color_redirect.jsp" method="get">

    <b>Enter your favorite color:</b>
    <input type="text" name="mycolor" width="20">
    <input type="submit" value="Your color here" name="submit">

</form>

</body>
</html>
