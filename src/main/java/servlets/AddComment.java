package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

import componentClasses.Comment;
import dbManagers.CommentsDBManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/addComment")
public class AddComment extends HttpServlet
{

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();

        HttpSession session = request.getSession(false);

        CommentsDBManager commentManager = new CommentsDBManager();

        String commentContent = request.getParameter("commentContent");
        int userId = (Integer)(session.getAttribute("userId"));
        int postId = Integer.parseInt((request.getParameter("postId")));

        int result = commentManager.insertComment(new Comment(0, postId, userId, commentContent));
        
        printWriter.println(result + " comment added!");
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
