package bean;


import java.util.ArrayList;
import java.util.List;
 
public class UserAccount {
	
	private int userId;
	private String userName;
	private String password;
	
	private List<String> roles;
 
	public UserAccount() {
 
	}

	public UserAccount(int userId, String userName, String password, String... roles) {
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		
		this.roles = new ArrayList<String>();
	      if (roles != null) {
	         for (String r : roles) {
	            this.roles.add(r);
	         }
	      }		
	}
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	 
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}	     
	
	public List<String> getRoles() { 
		return roles;
	}
	
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
}
