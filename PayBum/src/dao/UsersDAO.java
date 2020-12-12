package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
 
import bean.UserAccount;
import config.SecurityConfig;
import mysqlapp.business.CreditCard;
 
public class UsersDAO {
	
   private static String url = "jdbc:mysql://localhost/creditCardsdb?serverTimezone=Europe/Moscow&useSSL=false";
   private static String username = "root";
   private static String password = "dilom5051";
	
   private static final Map<String, UserAccount> mapUsers = new HashMap<String, UserAccount>();
 
   static {
      initUsers();
   }
 
   private static void initUsers() {
 
      // This user has a role as EMPLOYEE.
      UserAccount emp = new UserAccount("user1", "123", SecurityConfig.ROLE_USER);
 
      // This user has 2 roles EMPLOYEE and MANAGER.
      UserAccount mng = new UserAccount("admin", "admin", SecurityConfig.ROLE_ADMIN, SecurityConfig.ROLE_ADMIN);
 
      mapUsers.put(emp.getUserName(), emp);
      mapUsers.put(mng.getUserName(), mng);
   }
 
   // Find a User by userName and password.   
   public static UserAccount findUser(String username, String userPassword) {
       
   	UserAccount user = null;
       try{
           Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
           try (Connection conn = DriverManager.getConnection(url, username, password)){
                 
               String sql = "SELECT * FROM usersdb WHERE userName=userName";
               try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    
                   ResultSet resultSet = preparedStatement.executeQuery();
                   if(resultSet.next()){
                	                   	  
                	   String name = resultSet.getString(1);
                	   String password = resultSet.getString(2);
                	   user = new UserAccount(name, password);
                   }
               }
           }
       }
       catch(Exception ex){
           System.out.println(ex);
       }
       
       return user;
   }
   
	public static int insert(UserAccount account) {
	       
	       try{
	           Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
	           try (Connection conn = DriverManager.getConnection(url, username, password)){
	                 
	               String sql = "INSERT INTO usersdb (userName, userPassword) Values (?, ?)";
	               try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
	                   preparedStatement.setString(1, account.getUserName());
	                   preparedStatement.setString(2, account.getPassword());	                   
	                     
	                   return  preparedStatement.executeUpdate();
	               }
	           }
	       }
	       catch(Exception ex){
	           System.out.println(ex);
	       }
	       return 0;
	   }
}