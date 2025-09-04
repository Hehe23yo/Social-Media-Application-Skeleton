package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

import componentClasses.Post;
import dbManagers.PostsDBManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/addPost")
public class AddPost extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();

        HttpSession session = request.getSession(false);

        PostsDBManager postManager = new PostsDBManager();

        String postContent = request.getParameter("postContent");
        int userId = (Integer)(session.getAttribute("userId"));

        int result = postManager.insertPost(new Post(0, userId, postContent));
        
        printWriter.println(result + " post added!");
        try
        {
            TimeUnit.SECONDS.sleep(2);
        }
        catch(InterruptedException exception)
        {
            exception.printStackTrace();
        }

        request.getRequestDispatcher("home.jsp").forward(request, response);
    }
}
