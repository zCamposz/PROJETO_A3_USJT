/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.UsuarioDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Marçal
 */
public class UsuarioDao {

    Connection conn;

    public ResultSet autenticacaoUsuario(UsuarioDTO objusuariodto) {
        conn = new ConexaoDao().conectaBD();

        try {
            String sql = "select * from funcionario where login = ? and senha = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);

            pstm.setString(1, objusuariodto.getNome_usuario());
            pstm.setString(2, objusuariodto.getSenha_usuario());

            ResultSet rs = pstm.executeQuery();


            return rs;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDao: " + erro);
            return null;

        }

    }
    
    public ResultSet autenticacaoUsuario2(UsuarioDTO objusuariodto) {
        conn = new ConexaoDao().conectaBD();

        try {
            String sql = "select * from cliente where login = ? and senha = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);

            pstm.setString(1, objusuariodto.getNome_usuario());
            pstm.setString(2, objusuariodto.getSenha_usuario());

            ResultSet rs = pstm.executeQuery();
            
            return rs;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDao: " + erro);
            return null;

        }

    }

    public int funcionarioInsert(UsuarioDTO objusuariodto) {
        conn = new ConexaoDao().conectaBD();

        try {
            String sql = "INSERT INTO funcionario (nome, CPF, RG, idade, data_criacao,login,senha) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement pstm = conn.prepareStatement(sql);

            pstm.setString(1, objusuariodto.getCadastrar_nomeFun());
            pstm.setString(2, objusuariodto.getCadastrar_cpfFun());
            pstm.setString(3, objusuariodto.getCadastrar_rgFun());
            pstm.setString(4, objusuariodto.getCadastrar_idadeFun());
            pstm.setString(5, objusuariodto.getCadastrar_dataFun());
            pstm.setString(6, objusuariodto.getNome_usuario());
            pstm.setString(7, objusuariodto.getSenha_usuario());
            

            int rs = pstm.executeUpdate();
            return rs;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDao: " + erro);
            return 0;

        }

    }
    public ResultSet funRepetido(UsuarioDTO objusuariodto){
        conn = new ConexaoDao().conectaBD();

        try {
            String sql = "select * from funcionario where login = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);

            pstm.setString(1, objusuariodto.getNome_usuario());

            ResultSet rs = pstm.executeQuery();
            
            return rs;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDao: " + erro);
            return null;

        }

    }
    public int userInsert(UsuarioDTO objusuariodto) {
        conn = new ConexaoDao().conectaBD();

        try {
            String sql = "INSERT INTO cliente (nome, CPF, RG, idade, data_criacao,login,senha) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement pstm = conn.prepareStatement(sql);

            pstm.setString(1, objusuariodto.getCadastrar_nomeClient());
            pstm.setString(2, objusuariodto.getCadastrar_cpfClient());
            pstm.setString(3, objusuariodto.getCadastrar_rgClient());
            pstm.setString(4, objusuariodto.getCadastrar_idadeClient());
            pstm.setString(5, objusuariodto.getCadastrar_dataClient());
            pstm.setString(6, objusuariodto.getCadastrar_user());
            pstm.setString(7, objusuariodto.getCadastrar_senha());
            

            int rs = pstm.executeUpdate();
            return rs;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDao: " + erro);
            return 0;

        }

    }
    public ResultSet userRepetido(UsuarioDTO objusuariodto){
        conn = new ConexaoDao().conectaBD();

        try {
            String sql = "select * from cliente where login = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);

            pstm.setString(1, objusuariodto.getNome_usuario());

            ResultSet rs = pstm.executeQuery();
            
            return rs;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDao: " + erro);
            return null;

        }

    }

    public ResultSet procurar(UsuarioDTO objusuariodto){
        conn = new ConexaoDao().conectaBD();

        try {
            String sql = "select * from livro where titulo = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);

            pstm.setString(1, objusuariodto.getTitulo_livro());

            ResultSet rs = pstm.executeQuery();
            
            return rs;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDao: " + erro);
            return null;

        }

    }
    
    public int livroInsert(UsuarioDTO objusuariodto) {
        conn = new ConexaoDao().conectaBD();

        try {
            String sql = "INSERT INTO livro (descricao, valor, data_criacao, id_categoria, autor,editora,titulo,nota) VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement pstm = conn.prepareStatement(sql);

            pstm.setString(1, objusuariodto.getDescricao_livro());
            pstm.setString(2, objusuariodto.getValor_livro());
            pstm.setString(3, objusuariodto.getData_livro());
            pstm.setString(4, objusuariodto.getCategoria_livro());
            pstm.setString(5, objusuariodto.getAutor_livro());
            pstm.setString(6, objusuariodto.getEditora_livro());
            pstm.setString(7, objusuariodto.getTitulo_livro());
            pstm.setString(8, objusuariodto.getNota_livro());
            

            int rs = pstm.executeUpdate();
            return rs;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDao: " + erro);
            return 0;

        }

    }
    
    public int reservarLivro(UsuarioDTO objusuariodto) {
        conn = new ConexaoDao().conectaBD();

        try {
            String sql = "INSERT INTO livro (descricao, valor, data_criacao, id_categoria, autor,editora,titulo,nota) VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement pstm = conn.prepareStatement(sql);

            pstm.setString(1, objusuariodto.getDescricao_livro());
            pstm.setString(2, objusuariodto.getValor_livro());
            pstm.setString(3, objusuariodto.getData_livro());
            pstm.setString(4, objusuariodto.getCategoria_livro());
            pstm.setString(5, objusuariodto.getAutor_livro());
            pstm.setString(6, objusuariodto.getEditora_livro());
            pstm.setString(7, objusuariodto.getTitulo_livro());
            pstm.setString(8, objusuariodto.getNota_livro());
            

            int rs = pstm.executeUpdate();
            return rs;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDao: " + erro);
            return 0;

        }

    }
    



}
