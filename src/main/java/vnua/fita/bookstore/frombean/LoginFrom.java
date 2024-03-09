package vnua.fita.bookstore.frombean;

import java.util.ArrayList;
import java.util.List;

public class LoginFrom {
	private static String username;
	private static String password;
	@SuppressWarnings("static-access")
	public LoginFrom(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	public static String getUsername() {
		return username;
	}
	@SuppressWarnings("static-access")
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	@SuppressWarnings("static-access")
	public void setPassword(String password) {
		this.password = password;
	}
	public List<String> validate(){
		List<String> errors = new ArrayList<String>();
		if(username==null || username.trim().isEmpty()) {
			errors.add("Nhap username");
		}
		if(password==null || password.trim().isEmpty()) {
			errors.add("Nhap password");
		}
		return errors;
	}
}