package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import componentClasses.User;
import dbManagers.UserDBManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/registerHandler")
public class RegisterHandler extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();

        HttpSession session;

        UserDBManager userManager = new UserDBManager();

        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");

        try
        {
            if(userManager.isRegisteredUser(new User(0, userName, userPassword)))
            {
                printWriter.println("<h1> User already exists! Please head to the login page! </h1>");
                printWriter.println("<a href=" + "http://localhost:8080/social-media-woohoo/index.html" + ">Click here to go back!</a>");
            }
            else
                throw new SQLException();
        }
        catch(SQLException exception)
        {
            User user = new User(0, userName, userPassword);
            userManager.insertUser(user);
            
            session = request.getSession(true);
            session.setAttribute("userId", userManager.getUserId(user));

            request.getRequestDispatcher("home.jsp").forward(request, response);
        }
    }
}