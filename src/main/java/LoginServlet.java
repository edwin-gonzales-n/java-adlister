import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "login", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId, password;
        userId = request.getParameter("username");
        password = request.getParameter("password");

        LoginService loginService = new LoginService();
        boolean result = loginService.authenticate(userId,password);

        if (result){
            response.sendRedirect("profile.jsp");
            return;
        }
        else {
            response.sendRedirect("login.jsp");
            response.getWriter().println("<h3>You must be admin.  Please login as admin.</h3>");
            return;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
