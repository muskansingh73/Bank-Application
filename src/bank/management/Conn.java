package bank.management;
import java.sql.*;
//FIVE STEPS FOR DB CONNECTION
//1.REGISTER THE DRIVER
//2.CREATE CONNECTION
//3.CREATE STATEMENT
//4.EXECUTE QUERY
//5.CLOSE CONNECTION

public class Conn {
    
   Connection c;
   Statement s;
    
   public Conn(){
       try{
           //Class.forName(com.mysql.cj.jdbc.Driver);  //REGISTERING THE DRIVER
           c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","muskan");
           s = c.createStatement();
       }catch(Exception e){
           System.out.println(e);
       }
   }
    
}
