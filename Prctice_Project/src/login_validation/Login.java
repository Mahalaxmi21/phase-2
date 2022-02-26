package login_validation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String uName = request.getParameter("username");
		
		String uPass = request.getParameter("password");
		
		HttpSession ss = request.getSession();
		
		if(uName.trim().equals("admin") && uPass.trim().equals("admin123")) {
			ss.setAttribute("username", uName);
			ss.setAttribute("password", uPass);
			response.sendRedirect("Dashboard");
			
		}else
		{
			out.print("Invalid user");
			RequestDispatcher d = request.getRequestDispatcher("login_validation.html");
			d.include(request, response);
		}
	}
}
