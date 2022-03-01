package com.ecommerce.Product_details;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection {
	private Connection connection;
    
    public DBconnection(String dbURL, String user, String pwd) throws ClassNotFoundException, SQLException{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(dbURL, user, pwd);
    }
    
    public Connection getConnection(){
            return this.connection;
    }
    
    public void closeConnection() throws SQLException {
            if (this.connection != null)
                    this.connection.close();
    }
}