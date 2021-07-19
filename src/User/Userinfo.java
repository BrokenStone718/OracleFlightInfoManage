package User;

public class Userinfo {
	private String username;
	private String password;
	private String userID;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public Userinfo(String username, String password, String userID) {
		super();
		this.username = username;
		this.password = password;
		this.userID = userID;
	}
	public Userinfo() {}
	public Userinfo(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	};
	

}
