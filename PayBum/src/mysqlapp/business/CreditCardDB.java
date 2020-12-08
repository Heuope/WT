package mysqlapp.business;
 
import java.sql.*;
import java.util.ArrayList;
 
public class CreditCardDB {
 
    private static String url = "jdbc:mysql://localhost/creditCardsdb?serverTimezone=Europe/Moscow&useSSL=false";
    private static String username = "root";
    private static String password = "dilom5051";
    
    public static ArrayList<CreditCard> select() {
         
        ArrayList<CreditCard> cards = new ArrayList<CreditCard>();
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM cards");
                while(resultSet.next()){
                      
                    int id = resultSet.getInt(1);
                    int number = resultSet.getInt(2);
                    int cvv = resultSet.getInt(3);
                    int month = resultSet.getInt(4);
                    int year = resultSet.getInt(5);
                    
                    CreditCard card = new CreditCard(id, number, cvv, month, year);
                    cards.add(card);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return cards;
    }
    
    public static CreditCard selectOne(int id) {
         
    	CreditCard card = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "SELECT * FROM cards WHERE id=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){
 
                    	int cardId = resultSet.getInt(1);
                        int number = resultSet.getInt(2);
                        int cvv = resultSet.getInt(3);
                        int month = resultSet.getInt(4);
                        int year = resultSet.getInt(5);
                        
                        card = new CreditCard(cardId, number, cvv, month, year);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return card;
    }
    public static int insert(CreditCard card) {
         
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
     
    public static int update(CreditCard card) {
         
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "UPDATE cards SET num = ?, cvv = ?, mon = ?, yea = ? WHERE id = ?";
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
    
    public static int delete(int id) {
         
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){
                  
                String sql = "DELETE FROM cards WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                      
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