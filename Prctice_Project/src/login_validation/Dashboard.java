package login_validation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Dashboard
 */
public class Dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		HttpSession session = request.getSession();
		
		PrintWriter out = response.getWriter();
		
		if((session.getAttribute("username") != null) && (session.getAttribute("password") != null)) {
			
			out.println("<h3>Wllcome  " + session.getAttribute("username"));
			
			out.println("<br>You are now Logged in ....</h3>");
			
			out.println("<p><h4><a href='Logout'>Logout</a></h4>");
		}
		else {
			response.sendRedirect("login_validation.html");
		}
	}

}
