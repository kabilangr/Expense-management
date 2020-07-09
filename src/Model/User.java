package Model;
public class User 
{
	private String userName;
	private String userPassword;
	private String userNameCheck;
	private String userPassCheck;
	public User(String userName, String userPassword, String userNameCheck, String userPassCheck) {
		this.userName = userName;
		this.userPassword = userPassword;
		this.userNameCheck = userNameCheck;
		this.userPassCheck = userPassCheck;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserNameCheck() {
		return userNameCheck;
	}
	public void setUserNameCheck(String userNameCheck) {
		this.userNameCheck = userNameCheck;
	}
	public String getUserPassCheck() {
		return userPassCheck;
	}
	public void setUserPassCheck(String userPassCheck) {
		this.userPassCheck = userPassCheck;
	}
	

}
