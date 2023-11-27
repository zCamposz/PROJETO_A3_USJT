package DAO;

import com.mycompany.biblioteca.Categoria;
import com.mycompany.conexoes.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class CategoriaDAO {
    
        ResultSet rs;
    
        public int getNextId() throws SQLException {
        String sql = "SELECT MAX(id_categoria) + 1 FROM categoria";
        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        throw new SQLException("Falha ao obter prÃ³ximo ID para login.");
    }
    
    
    public void cadastrarCategoria(Categoria categoria) throws SQLException{
        String sql = "INSERT INTO CATEGORIA (id_categoria, nome) values (?, ?)";
        
        PreparedStatement ps = null;
        
        try{
        ps = Conexao.getConexao().prepareStatement(sql);
        ps.setInt(1, getNextId());
        ps.setString(2,categoria.getNome());
        
        ps.execute();
        ps.close();
        
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        
    }
    
    public Categoria pesquisarCategoriaPorNome(String nome) throws SQLException {
        String sql = "SELECT * FROM categoria WHERE nome LIKE ?";
        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setString(1, nome);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Categoria categoria = new Categoria();
                    categoria.setId_categoria(rs.getInt("id_categoria"));
                    categoria.setNome(rs.getString("nome"));

                    return categoria;

                } else {
                    System.out.println("Nenhuma categoria encontrado com esse nome: " + nome);
                    return null;
                }

            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }

    }
    
    public Categoria pesquisarCategoriaPorID(int idcategoria) throws SQLException {
        String sql = "SELECT * FROM categoria WHERE id_categoria LIKE ?";
        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setInt(1, idcategoria);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Categoria categoria = new Categoria();
                    categoria.setId_categoria(rs.getInt("id_categoria"));
                    categoria.setNome(rs.getString("nome"));


                    return categoria;

                } else {
                    System.out.println("Nenhuma categoria encontrado com esse id: " + idcategoria);
                    return null;
                }

            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }

    }
    
    
}
