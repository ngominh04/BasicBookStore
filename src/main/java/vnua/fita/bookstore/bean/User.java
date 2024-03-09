package vnua.fita.bookstore.bean;

public class User {

	private String username;
	private String pasword;
	private int role;
	private String fullname;
	private String email;
	private String address;
	private String mobile;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String username, String pasword, int role, String fullname, String email, String address,
			String mobile) {
		super();
		this.username = username;
		this.pasword = pasword;
		this.role = role;
		this.fullname = fullname;
		this.email = email;
		this.address = address;
		this.mobile = mobile;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasword() {
		return pasword;
	}
	public void setPasword(String pasword) {
		this.pasword = pasword;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
	}
