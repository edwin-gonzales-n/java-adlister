import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

@WebServlet(name = "InputServlet", urlPatterns = "/in")
public class InputServlet extends HttpServlet
{
    private int hitCount;

    public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
    {
        // Set response content type
        res.setContentType("text/html");
        String title = "Total Number of Hits";
        String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

        hitCount++;
        PrintWriter pw=res.getWriter();
        String user=req.getParameter("mytext");
        pw.println("<h1 align = \"center\" Style=\"color:white\">Welcome "+user+"!!!</h1>");
        pw.println(docType +
                "<title>" + title + "</title>\n" +
                "<body bgcolor = \"#85144b\">\n" +
                "<h1 align = \"center\">" + title + "</h1>\n" +
                "<h2 align = \"center\" Style=\"color:red\">" + hitCount + "</h2>\n"
      );
    }
    public void init() {
        // Reset hit counter.
        hitCount = 0;
    }

}
