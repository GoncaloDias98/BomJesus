/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backEnd;
import frontEnd.Inicio;
import frontEnd.RegisterForm;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.springframework.security.crypto.bcrypt.BCrypt;


public class Operations {
    public static boolean isLogin(String username, String password, JFrame frame){
        try{
            Connection myConn =Inicio.getConnection();
            String mySqlQuery = 
                    "SELECT idAdministrador, username, password FROM administrador WHERE username = '"+username+"'";
            PreparedStatement preparedStatement = myConn.prepareStatement(mySqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                LoginSession.idAdministrador = resultSet.getInt("idAdministrador");
                LoginSession.username = resultSet.getString("Username");
                String hashedpassword = resultSet.getString("password");
                if(BCrypt.checkpw(password, hashedpassword)){
                    System.out.println(password + " "+ hashedpassword);
                return true;
                }
            }
            
        }catch (Exception exception){
            JOptionPane.showMessageDialog(frame, "Database error: " + exception.getMessage());
        }
        
        return false;
    }
    
    public static boolean UsernameExists(String username, JFrame frame){
    try{
            Connection myConn =Inicio.getConnection();
            String mySqlQuery = 
                    "SELECT username FROM administrador WHERE username = '"+username+"'";
            PreparedStatement preparedStatement = myConn.prepareStatement(mySqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println(username);
            if(resultSet.next() == false){
                return false;
            }else{
                while(resultSet.next()){
                    return true;
                }
            }
            
        }catch (Exception exception){
            JOptionPane.showMessageDialog(frame, "Database error: " + exception.getMessage());
        }
        
        return false;

    }
}
