package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import services.*;

/**
 *
 * @author Dakota Chatt
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        String logout = request.getParameter("logout");
        
        if(logout != null) {
            session.invalidate();
            String message = "You have been successfully logged out!";
            request.setAttribute("message", message);
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
        
        if(session.getAttribute("username") != null) {
            response.sendRedirect("home");
            return;
        }
    
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        request.setAttribute("username", username);
        request.setAttribute("password", password);
        
        if(username.equals("") || username == null || password.equals("") || password == null) {
            String message = "Please enter both a username and password";
            request.setAttribute("message", message);

            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
        
        AccountService account = new AccountService();
        
        if(account.login(username, password) != null) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            
            response.sendRedirect("home");
            return;
            
        } else {
            String message = "Invalid username or password";
            request.setAttribute("message", message);
            
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
    }

}
