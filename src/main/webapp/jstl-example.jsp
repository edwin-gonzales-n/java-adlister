<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Gonzo
  Date: 3/27/18
  Time: 10:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jstl-example</title>
</head>
<body>

<h1>JSTL Example</h1>

<c:if test="${false}">
    <h2>You will never see this</h2>
</c:if>

<c:if test="${true}">
    <h2>HELLO!!!</h2>
</c:if>

<ul>
    <c:forEach var="n" items="${[1,2,3,4,5,6,7,8,9,10]}">
        <li>${n}</li>
    </c:forEach>
</ul>



</body>
</html>
