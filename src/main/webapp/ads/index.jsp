<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Gonzo
  Date: 3/29/18
  Time: 5:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ads Listing</title>
<%@ include file="../partials/head.jsp"%>
        </head>
<body>

<%@include file="../partials/navbar.jsp"%>

<h3 align="center">WELCOME ${username}!! ADS WILL DISPLAY HERE!</h3>

<div class="container">
    <div class="row-md">
        <c:forEach var="ad" items="${ads}">
            <h1>${ad.title}</h1>
            <p>${ad.description}</p>
        </c:forEach>
    </div>
</div>

</body>

</html>
