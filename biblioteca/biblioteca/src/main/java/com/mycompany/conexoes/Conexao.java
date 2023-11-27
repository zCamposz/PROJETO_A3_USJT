package com.mycompany.conexoes;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
    private static final String USERNAME = "root";
    private static final String PASSWORD = "senharoot";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/biblioteca";
    public static Connection conn;

    public static Connection getConexao(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            return conexao;  // Retorna a conexão estabelecida
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver do banco de dados não localizado.");
            ex.printStackTrace();
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao acessar o banco: " + ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }
}


