package vnua.fita.bookstore.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver"; 
	private static String jdbcURL = "jdbc:mysql://localhost:3306/bookshop";
	private static String jdbcUsername ="root";
	private static String jdbcPassword ="041103";
	
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return connection;
	}
	
}
