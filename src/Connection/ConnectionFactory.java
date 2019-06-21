/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author D4rks
 */
public class ConnectionFactory {
    
    private final static String DRIVE = "com.mysql.jdbc.Driver";
    private final static String URL = "jdbc:mysql://localhost:3306/firstcrud";
    private final static String USER = "root";
    private final static String PASS = "Narigaz@7";
    
    public static Connection getConnection(){
        try {
            Class.forName(DRIVE);
            
           return DriverManager.getConnection(URL,USER,PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro na conexao: ",ex);  
        }
    }
    
    public static void closeConnection(Connection con){
        try {
            if(con!=null){
            con.close();
        }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE,null,ex);        }
    }
    
    public static void closeConnection(Connection con , PreparedStatement stmt){
        closeConnection(con);
        try {
            if (stmt != null) {
                stmt.close();
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE,null,ex);        }
    }
    
    public static void closeConnection(Connection con , PreparedStatement stmt , ResultSet rs){
        closeConnection(con,stmt);
        try {
            if (rs != null) {
                rs.close();        
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE,null,ex);        }
    }
}
