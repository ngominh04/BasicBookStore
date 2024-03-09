package vnua.fita.bookstore.model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import vnua.fita.bookstore.bean.User;
import vnua.fita.bookstore.database.Database;


public class UserDao {
	public static void selectAll()  {
		String SELECT_ALL ="SELECT * FROM tbluser";
		try(Connection connection =Database.getConnection();
				Statement statement=connection.createStatement()){
			ResultSet resultSet = statement.executeQuery(SELECT_ALL);
			while (resultSet.next()) {
				String id = resultSet.getString("id");
				String username = resultSet.getString("username");
				
				System.out.println(id+" - "+username);
				
			}
		}catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
	public static User checkLogin(String username,String password) {
		String sql = "select *from tbluser where username = ? and password = ?";
		User user = null;
		try (Connection connection = Database.getConnection();
		PreparedStatement statement=connection.prepareStatement(sql);){
			
		statement.setString(1, username);
		statement.setString(2, password);
		ResultSet resultSet = statement.executeQuery();
		
		
		if(resultSet.next()) {
			user = new User();
			user.setFullname(resultSet.getString("fullname"));
			user.setUsername(username);
			user.setPasword(password);
			user.setAddress(resultSet.getString("address"));
			user.setEmail(resultSet.getString("email"));
			user.setMobile(resultSet.getString("mobile"));
			user.setRole(resultSet.getByte("role"));
		}
		connection.close();
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		return user;
		
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		checkLogin("a", "12345");
		System.out.println(checkLogin("a", "12345"));
//		selectAll();
	}
}
