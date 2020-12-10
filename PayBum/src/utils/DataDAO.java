package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
 
import bean.UserAccount;
import config.SecurityConfig;
import mysqlapp.business.CreditCard;
 
public class DataDAO {
	
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
   public static UserAccount findUser(String userName, String password) {
	   
   }
   
   public static UserAccount findUser(int userId, String userName, String password) {
       
   	UserAccount user = null;
       try{
           Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
           try (Connection conn = DriverManager.getConnection(url, username, password)){
                 
               String sql = "SELECT * FROM usersdb WHERE userName=userName";
               try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                   preparedStatement.setInt(1, id);                    
                   ResultSet resultSet = preparedStatement.executeQuery();
                   if(resultSet.next()){
                	                   	   
                	   int userId = resultSet.getInt(1);
                	   String userName = resultSet.getString(2);
                	   String password = resultSet.getString(3);
                	   user = new UserAccount(userId, userName, password);
                   }
               }
           }
       }
       catch(Exception ex){
           System.out.println(ex);
       }
       
       return user;
   }
   
	public static int insert(String userName, String password) {
	       
	       try{
	           Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
	           try (Connection conn = DriverManager.getConnection(url, username, password)){
	                 
	               String sql = "INSERT INTO cards (num, cvv, mon, yea) Values (?, ?, ?, ?)";
	               try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
	                   preparedStatement.setInt(1, card.getNumber());
	                   preparedStatement.setInt(2, card.getCvv());
	                   preparedStatement.setInt(3, card.getMonth());
	                   preparedStatement.setInt(4, card.getYear());
	                     
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