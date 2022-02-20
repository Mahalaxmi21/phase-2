package servletGetPost;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Posthandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
		 	PrintWriter out = response.getWriter();
	        out.println("<html><body>");
	        out.print("<hr>");
	        out.print("<h3>Welcome to Post Handler</h3>");
	        out.print("<hr>");
	       
	        String name = request.getParameter("name");
	        String password = request.getParameter("password");
	        
	        out.println("Name =" + name + "<br>Pasword =" + password);
	        out.println("</body></html>");
	        out.print("<hr>");
	}

}
