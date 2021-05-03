package frontEnd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

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
  
  
  public LocalTime Hora(String data) {
        //CRIO O OBJETO formatodata com o formato ("d/MM/yyyy")
        DateTimeFormatter formatohora = DateTimeFormatter.ofPattern("HH:mm");

        //crio o objeto localdate que formata a informação intoduzida para o formato que eu paremetrizei em formatodata
        LocalTime localHora = LocalTime.parse(data, formatohora);

        return localHora;
    }
  
  public String Horatexto(LocalTime data) {
        DateTimeFormatter formatohora = DateTimeFormatter.ofPattern("HH:mm");

        //crio o objeto localdate que formata a informação intoduzida para o formato que eu parameterizei em formatodata
        String hora = formatohora.format(data);

        return hora;
    }

}