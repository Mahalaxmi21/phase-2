package Product_id;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class LoginProduct_id
 */
public class LoginProduct_id extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String name="scott";
		String pass="tiger";
		
		response.setContentType("text/html");
		
		String pId = request.getParameter("p_ID");
	
		PrintWriter out = response.getWriter();
		
		
		String query="select * from product_Details where product_Id=?";
		
		out.print("<h1>Displaying the Product Details...</h1>");
		
		out.print("<table border='1'><tr><th>Product Id</th><th>Product Name</th><th>Product Price</th></tr>");
		
		try {
	      Class.forName("oracle.jdbc.driver.OracleDriver");
	      Connection db = DriverManager.getConnection(url, name, pass);
	      PreparedStatement st=  db.prepareStatement(query);
	      
	      st.setString(1, pId);
	      
	      ResultSet rs =st.executeQuery();
	      
	      while(rs.next()) {
	    	  
	    	  out.print("<tr><td>");
	    	  out.println(rs.getInt(1));
	    	  out.print("</td>");
	    	  out.print("<td>");
	    	  out.print(rs.getString(2));
	    	  out.print("</td>");
	    	  out.print("<td>");
	    	  out.print(rs.getFloat(3));
	    	  out.print("</td>");
	    	  out.print("</tr>");
	    
	    	  
			}
	      
		}
		catch(Exception e){
			
			System.out.println("Some Issue : "+ e.getMessage());
			
			
		}
		
		out.print("</table>");
		
	}
}
