<%@ page import="java.util.Random" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: Gonzo
  Date: 3/28/18
  Time: 11:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Random rand = new Random();
    int  n = rand.nextInt(100) + 1;
    int userGuesses = 0;
%>

<%
    String title = "Your guess is: ";
    String randomNumber = "The random number was ";
    String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
    response.setContentType("text/html");
    PrintWriter pw=response.getWriter();
    int userNumber= Integer.parseInt(request.getParameter("mynumber"));

    if (userNumber == n){
        pw.printf("%s\n%s%s%s\n%s bgcolor = \"%s\">\n" +
                        "<h1 align = \"center\">%s</h1>\n" +
                        "<h2 align =\"center\" Style=\"color: white\">%s</h2>\n" +
                        "<h2 alin = \"center\" Style=\"color: white\">%s %s",
                docType,"<title>", title,"</title>","<body", "blue",title,userNumber,randomNumber, n);
    } else pw.printf("<h1 algin = \"center\">NOPE!!!! %s %s, you suck!",randomNumber, n);
           pw.printf("\n<a href=\"guess.jsp\">Now go back and play again!</a>");

%>
</body>
</html>
