package com.mycompany.biblioteca;


import View.Inicio;
import java.sql.SQLException;

public class BibliotecaMain{
    Inicio inicio = new Inicio();
    
    public static void main (String[] args) throws SQLException{
        
        new Inicio().setVisible(true);

    }
}