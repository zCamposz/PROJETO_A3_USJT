package DAO;

import com.mycompany.biblioteca.Funcionario;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.mycompany.biblioteca.Livro;
import com.mycompany.conexoes.Conexao;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LivroDAO {
    
    ResultSet rs;
    ArrayList<Livro> lista = new ArrayList<>();
    
    
    public void cadastrarLivro(Livro livro) throws SQLException{
        String sql = "INSERT INTO LIVRO (descricao, valor, id_categoria) values (?, ?, ?)";
        
        PreparedStatement ps = null;
        
        try{
        ps = Conexao.getConexao().prepareStatement(sql);
        ps.setString(1,livro.getDescricao());
        ps.setDouble(2, livro.getValor());
        ps.setInt(3, livro.getId_categoria());
        
        ps.execute();
        ps.close();
        
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        
    }
    
    public void atualizarLivro(Livro livro) throws SQLException {
    String sql = "UPDATE livro SET descricao=?, valor=?, nota=?, id_categoria=? WHERE id_livro=?";

    try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
        ps.setString(1, livro.getDescricao());
        ps.setDouble(2, livro.getValor());
        ps.setInt(3, livro.getNota());
        ps.setInt(4, livro.getId_categoria());
        ps.setInt(5, livro.getId_livro());

        int linhasAfetadas = ps.executeUpdate();

        if (linhasAfetadas > 0) {
            System.out.println("Livro atualizado com sucesso!");
        } else {
            System.out.println("Nenhum livro atualizado. Verifique se o ID é válido.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    
    public void avaliarLivro(Livro livro) throws SQLException {
    String sql = "UPDATE livro SET nota=? WHERE id_livro=?";

    try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
        ps.setInt(1, livro.getNota());
        ps.setInt(2, livro.getId_livro());

        int linhasAfetadas = ps.executeUpdate();

        if (linhasAfetadas > 0) {
            System.out.println("Livro avaliado com sucesso!");
        } else {
            System.out.println("Nenhum livro atualizado. Verifique se o ID é válido.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    
    public void deletarLivro(int idLivro) throws SQLException {
        String sql = "DELETE FROM LIVRO WHERE id_livro = ?";

        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setInt(1, idLivro);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Livro pesquisarLivroPorNome(String descricao) throws SQLException {
        String sql = "SELECT * FROM LIVRO WHERE descricao = ?";
        Livro livro = new Livro();

        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setString(1, descricao);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    livro.setId_livro(rs.getInt("id_livro"));
                    livro.setDescricao(rs.getString("descricao"));
                    livro.setData_criacao(rs.getDate("data_criacao"));
                    livro.setValor(rs.getDouble("valor"));
                    livro.setId_categoria(rs.getInt("id_categoria"));
                    livro.setNota(rs.getInt("nota"));
                }
            }
        }

        return livro;
    }
    
        public Livro pesquisarLivroPorID(int idLivro) throws SQLException {
        String sql = "SELECT * FROM livro WHERE id_livro LIKE ?";
        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setInt(1, idLivro);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                                Livro livro = new Livro();
                                livro.setId_livro(rs.getInt("id_livro"));
                                livro.setDescricao(rs.getString("descricao"));
                                livro.setData_criacao(rs.getDate("data_criacao"));
                                livro.setValor(rs.getDouble("valor"));
                                livro.setId_categoria(rs.getInt("id_categoria"));
                                livro.setNota(rs.getInt("nota"));


                    return livro;

                } else {
                    System.out.println("Nenhum livro encontrado com esse id: " + idLivro);
                    return null;
                }

            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }

    }
    
    
    public ArrayList<Livro> listarLivros(){
        String sql = "SELECT * FROM LIVRO";
        
        PreparedStatement ps = null;
        
        try{
        ps = Conexao.getConexao().prepareStatement(sql);
        rs = ps.executeQuery();
        
        while(rs.next()){
            Livro livro = new Livro();
            livro.setId_livro(rs.getInt("id_livro"));
            livro.setDescricao(rs.getString("descricao"));
            livro.setData_criacao(rs.getDate("data_criacao"));
            livro.setValor(rs.getDouble("valor"));
            livro.setId_categoria(rs.getInt("id_categoria"));
            livro.setNota(rs.getInt("nota"));

            
            
            lista.add(livro);
        }
        
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return lista;
    }
}
