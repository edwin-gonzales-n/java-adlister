import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import com.google.gson.Gson;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean validAttempt = username.equals("admin") && password.equals("password");
        HttpSession session = request.getSession();
        Json json = new Json();
        Data data = new Gson().fromJson(json.json, Data.class);

        if(validAttempt){
            session.removeAttribute("login_error");
            session.setAttribute("user", username);
            session.setAttribute("json_data", data);
            response.sendRedirect("/profile");
        } else {
            session.setAttribute("login_error", "<p style=\"color:red\">Sorry \"username\" or \"password\" error!</p>");
            response.sendRedirect("/login");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("username") != null) {
            response.sendRedirect("/profile");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    class Json {
        String json =
        "     {" +
                "                        'title': 'Computing and Information systems'," +
                "                        'id' : 1," +
                "                        'children' : 'true'," +
                "                        'groups' : [{" +
                "                            'title' : 'Level one CIS'," +
                "                            'id' : 2," +
                "                            'children' : 'true'," +
                "                            'groups' : [{" +
                "                                'title' : 'Intro To Computing and Internet'," +
                "                                'id' : 3," +
                "                                'children': 'false'," +
                "                                'groups':[]" +
                "                                }]" +
                "                            }]" +
                "    }";

    }

    class Data {
        private String title;
        private Long id;
        private Boolean children;
        private List<Data> groups;

        public String getTitle() { return title; }
        public Long getId() { return id; }
        public Boolean getChildren() { return children; }
        public List<Data> getGroups() { return groups; }

        public void setTitle(String title) { this.title = title; }
        public void setId(Long id) { this.id = id; }
        public void setChildren(Boolean children) { this.children = children; }
        public void setGroups(List<Data> groups) { this.groups = groups; }

        public String toString() {
            return String.format("<div class = \"col-md-6\" \"centered\" style: \"text-align:center\">" +
                    "<h2>Title: %s</h2>" +
                    "<p>id: %d</p>", title, id);
        }
    }

}
