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

@WebServlet("/loginHandler")
public class LoginHandler extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();

        HttpSession session;
        
        UserDBManager userManager = new UserDBManager();

        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");
        
        try
        {
            User user = new User(0, userName, userPassword);
            if(userManager.isRegisteredUser(user))
            {
                session = request.getSession(true);
                session.setAttribute("userId", userManager.getUserId(user));
                request.getRequestDispatcher("home.jsp").forward(request, response);
            }
            else
                response.sendRedirect("http://localhost:8080/social-media-woohoo/login.jsp");;
        }
        catch(SQLException exception)
        {
            printWriter.println("<h1>" + "User Not found!" + "</h1>");
            printWriter.println("<a href=" + "http://localhost:8080/social-media-woohoo/index.html" + ">Click here to go back!</a>");
        }
    }
}