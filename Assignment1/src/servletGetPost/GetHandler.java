package servletGetPost;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class GetHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.print("<hr>");
        out.print("<h3>Welcome to Get Handler</h3>");
		out.print("<hr>");
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        out.println("Name=" + name + "<br>Address=" + address);
       
        out.println("</body></html>");
		out.print("<hr>");

	}

	
}
