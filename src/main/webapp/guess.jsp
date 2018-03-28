<%--
  Created by IntelliJ IDEA.
  User: Gonzo
  Date: 3/28/18
  Time: 10:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/guess" method="get">

        <b>Guess a number between 1 and 100:</b>
        <input type="text" name="mynumber" width="20">
        <input type="submit" value="guess me!" name="submit">

    </form>


</body>
</html>
