package JDBCSetup2;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import JDBCSetup2.DBConnection;

/**
 * Servlet implementation class ProductDetails
 */
public class ProductDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetails() {
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
           
           DBConnection conn = new DBConnection(props.getProperty("url"), props.getProperty("user"), props.getProperty("password"));
           Statement stmt = conn.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
           
           
           //stmt.executeUpdate("insert into eproduct (name, price, date_added) values ('Power Bank', 10000.00, now())");
           
           ResultSet rst = stmt.executeQuery("select * from eproduct");
           out.print("<h3>Product Information</h3>");
           out.print("<hr>");
           
           
           while (rst.next()) {
                   out.println("Product id is : "+rst.getInt("ID") + ", Product Name is : " + rst.getString("name") +", Product Price is :"+ rst.getInt("price")+", Product MFD is : "+ rst.getDate("date_added")+ "<Br>");
           }
           
           stmt.close();
        //   out.println("</body></html>");
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
