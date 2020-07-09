package Model;
public class Admin 
{
private String adminName;
private String adminPassword;
private String adminNameCheck;
private String adminPassCheck;
public Admin(String adminName, String adminPassword, String adminNameCheck, String adminPassCheck) {
	this.adminName = adminName;
	this.adminPassword = adminPassword;
	this.adminNameCheck = adminNameCheck;
	this.adminPassCheck = adminPassCheck;
}
public String getAdminName() {
	return adminName;
}
public void setAdminName(String adminName) {
	this.adminName = adminName;
}
public String getAdminPassword() {
	return adminPassword;
}
public void setAdminPassword(String adminPassword) {
	this.adminPassword = adminPassword;
}
public String getAdminNameCheck() {
	return adminNameCheck;
}
public void setAdminNameCheck(String adminNameCheck) {
	this.adminNameCheck = adminNameCheck;
}
public String getAdminPassCheck() {
	return adminPassCheck;
}
public void setAdminPassCheck(String adminPassCheck) {
	this.adminPassCheck = adminPassCheck;
}

}
