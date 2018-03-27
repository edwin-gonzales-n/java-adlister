<%--
  Created by IntelliJ IDEA.
  User: Gonzo
  Date: 3/26/18
  Time: 11:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Counter</title>
    <%! int counter = 0; %>
    <% counter += 1; %>
</head>
<body>
<h2>Count is: <%= counter %>.</h2>
</body>
</html>
