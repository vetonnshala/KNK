    
package Stacioni;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbConnection {
	private static Connection dbconnection;


		public static Connection getConnection() {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				dbconnection = DriverManager.getConnection("jdbc:mysql://localhost/Stacioni", "root", "root123");
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
			return dbconnection ;
}
}