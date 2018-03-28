import javax.servlet.annotation.WebServlet;

@WebServlet(name = "Drill1Servlet", urlPatterns = "/name")
public class Drill1Servlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        String name = request.getParameter("username");
        request.setAttribute("username", name);
        request.getRequestDispatcher("drill1_redirect.jsp").forward(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        request.getRequestDispatcher("drill1.jsp").forward(request, response);
    }
}
