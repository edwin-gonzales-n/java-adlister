<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // Get session creation time.
    Date createTime = new Date(session.getCreationTime());

    // Get last access time of this Webpage.
    Date lastAccessTime = new Date(session.getLastAccessedTime());

    String title = "Welcome Back to my website";
    Integer visitCount = new Integer(0);
    String visitCountKey = new String("visitCount");
    String userIDKey = new String("userID");
    String userID = new String("ABCD");

    // Check if this is new comer on your Webpage.
    if (session.isNew() ){
        title = "Welcome to my website";
        session.setAttribute(userIDKey, userID);
        session.setAttribute(visitCountKey,  visitCount);
        session.setAttribute("navbar_logout", "<jsp:include page=\"/WEB-INF/partials/navbar_logout.jsp\"/>");
    } else {
        session.setAttribute("navbar",  "<jsp:include page=\"/WEB-INF/partials/navbar.jsp\" />");
    }
    visitCount = (Integer)session.getAttribute(visitCountKey);
    visitCount = visitCount + 1;
    userID = (String)session.getAttribute(userIDKey);
    session.setAttribute(visitCountKey,  visitCount);
%>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>

${navbar}
${navbar_logout}

<div class="container">
    <h1>Here Are all the ads!</h1>

    <c:forEach var="ad" items="${ads}">
        <div class="col-md-6">
            <h2>${ad.title}</h2>
            <p>${ad.description}</p>
        </div>
    </c:forEach>
</div>

</body>
</html>
