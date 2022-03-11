package APP3.product_details;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import APP3.product_details.DBConnection3;
/**
 * Servlet implementation class productDetails
 */
public class product_Details extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public product_Details() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
             PrintWriter out = response.getWriter();
             out.println("<html><body>");
             
            InputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties");
            Properties props = new Properties();
            props.load(in);
            
            
            DBConnection3 conn = new DBConnection3(props.getProperty("url"), props.getProperty("user"), props.getProperty("password"));
            CallableStatement stmt = conn.getConnection().prepareCall("{call add_product(?, ?)}");
            stmt.setString(1, "Moter");
            stmt.setBigDecimal(2, new BigDecimal(3000.50));
            stmt.executeUpdate();
            
            out.println("Stored procedure has been executed.<Br>");
            stmt.close();
            
            
            out.println("</body></html>");
            conn.closeConnection();
            
    } catch (ClassNotFoundException e) {
            e.printStackTrace();
    } catch (SQLException e) {
            e.printStackTrace();
    }
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
