/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backEnd;
import frontEnd.Inicio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class Operations {
    public static boolean isLogin(String username, String password, JFrame frame){
        try{
            Connection myConn =Inicio.getConnection();
            String mySqlQuery = 
                    "SELECT idAdministrador, username FROM administrador WHERE username = '"+username+"' AND Password = '"+password+"'";
            PreparedStatement preparedStatement = myConn.prepareStatement(mySqlQuery);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()){
                LoginSession.idAdministrador = resultSet.getInt("idAdministrador");
                LoginSession.username = resultSet.getString("Username");
                
                return true;
            }
            
        }catch (Exception exception){
            JOptionPane.showMessageDialog(frame, "Database error: " + exception.getMessage());
        }
        
        return false;
    }
}
