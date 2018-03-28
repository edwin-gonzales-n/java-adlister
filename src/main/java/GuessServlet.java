import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet(name = "GuessServlet",urlPatterns = "/guess")
public class GuessServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Random rand = new Random();
        int  n = rand.nextInt(100) + 1;
        int userGuesses = 0;

        int userNumber= Integer.parseInt(request.getParameter("mynumber"));
        String youWon = "YES!  YOU WON!";
        String tryAgain = "<a href=\"/guess\">Click to try again</a>";

        if (userNumber == n){
            request.setAttribute("won", youWon);
        } else
            request.setAttribute("lost",tryAgain);

        request.setAttribute("mynumber", userNumber);
        request.setAttribute("random",n);
        request.getRequestDispatcher("guess_redirect.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("guess.jsp").forward(request, response);
    }
}
