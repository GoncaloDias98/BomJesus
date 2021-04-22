package frontEnd;

import java.sql.Connection;
import java.sql.DriverManager;

public class Inicio {

  public static Connection getConnection() throws Exception{
    try{
      String driver= "com.mysql.cj.jdbc.Driver";
      String url = "jdbc:mysql://localhost:3306/mydb";
      String username="root";
      String password="root";
      Class.forName(driver);
      
      Connection conn = DriverManager.getConnection(url,username,password);
      System.out.println("Conectado a base de dados!");
      return conn;
    } catch(Exception e){
      System.out.println(e);
      System.out.println("Conecçao a base de dados falhada");
    }
    return null;
  }

  public static void main(String[] args) throws Exception {
    getConnection();
    Dashboard dash= new Dashboard();
    dash.setVisible(true);
  }

}