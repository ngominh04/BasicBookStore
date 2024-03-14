package vnua.fita.bookstore.model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import vnua.fita.bookstore.bean.User;
import vnua.fita.bookstore.database.Database;


public class UserDao {
	private static PreparedStatement preStatement;
	private static ResultSet resultSet;
	
	public static User findUser(String username, String password) {
		String sql = "SELECT * FROM tbluser WHERE username = ? AND password = ?";
		
		Connection jdbcConnection = Database.getConnection();
		try {
			preStatement = jdbcConnection.prepareStatement(sql);
			preStatement.setString(1, username);
			preStatement.setString(2, password);
			resultSet = preStatement.executeQuery();
			if (resultSet.next()) {
				return new User(resultSet.getString("username"),
						resultSet.getString("password"), resultSet.getInt("role"),
						resultSet.getString("fullname"), resultSet.getString("email"),
						resultSet.getString("mobile"), resultSet.getString("address"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static User findUser(String username) {
		String sql = "SELECT * FROM tbluser WHERE username = ?";
		
		Connection jdbcConnection = Database.getConnection();
		try {
			preStatement = jdbcConnection.prepareStatement(sql);
			preStatement.setString(1, username);
			resultSet = preStatement.executeQuery();
			if (resultSet.next()) {
				return new User(resultSet.getString("username"),
						resultSet.getString("password"), resultSet.getInt("role"),
						resultSet.getString("fullname"), resultSet.getString("email"),
						resultSet.getString("mobile"), resultSet.getString("address"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		checkLogin("a", "12345");
//		System.out.println(checkLogin("a", "12345"));
//		selectAll();
	}
}
