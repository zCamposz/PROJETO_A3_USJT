/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


/**
 *
 * @author Marçal
 */
public class ConexaoDao {
    public Connection conectaBD(){
        Connection conn = null;
        String url = "jdbc:mysql://localhost:3306/autentificacao?user=root&password=";
        
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"ConexaoDAO "+ex.getMessage());
        }
        

        return conn;
        
    
    
    }
    
}
