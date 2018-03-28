import javax.servlet.annotation.WebServlet;

@WebServlet(name = "ColorServlet", urlPatterns = "/color")
public class ColorServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        String usercolor = request.getParameter("mycolor");
        request.setAttribute("mycolor", usercolor);
        request.getRequestDispatcher("color_redirect.jsp").forward(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, java.io.IOException {
        request.getRequestDispatcher("color.jsp").forward(request, response);
    }
}
