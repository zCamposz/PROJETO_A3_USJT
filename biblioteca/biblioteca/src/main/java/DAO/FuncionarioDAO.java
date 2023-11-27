package DAO;

import com.mycompany.biblioteca.Funcionario;
import DAO.UsuarioDAO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import com.mycompany.conexoes.Conexao;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;

public class FuncionarioDAO {
    
    ResultSet rs;
    ArrayList<Funcionario> lista = new ArrayList<>();
    
    public void cadastrarFuncionario(Funcionario funcionario) throws SQLException{
        String sql = "INSERT INTO FUNCIONARIO (nome, cpf, rg, idade, id_login) values (?, ?, ?, ?, ?)";
        
        PreparedStatement ps = null;
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        try{
        ps = Conexao.getConexao().prepareStatement(sql);
        ps.setString(1,funcionario.getNome());
        ps.setString(2, funcionario.getCPF());
        ps.setString(3, funcionario.getRG());
        ps.setInt(4, funcionario.getIdade());
        ps.setInt(5, funcionario.getId_login());

        
        ps.execute();
        ps.close();
        
        }catch(SQLException e){
            e.printStackTrace();
        } 
    }
    
    public Funcionario pesquisarFuncionarioPorID(int idfuncionario) throws SQLException {
        String sql = "SELECT * FROM funcionario WHERE id_funcionario LIKE ?";
        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setInt(1, idfuncionario);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                                Funcionario funcionario = new Funcionario();
                                funcionario.setId_funcionario(rs.getInt("id_funcionario"));
                                funcionario.setNome(rs.getString("nome"));
                                funcionario.setCPF(rs.getString("CPF"));
                                funcionario.setRG(rs.getString("RG"));
                                funcionario.setIdade(rs.getInt("idade"));
                                funcionario.setData_criacao(rs.getDate("data_criacao"));


                    return funcionario;

                } else {
                    System.out.println("Nenhum funcionario encontrado com esse id: " + idfuncionario);
                    return null;
                }

            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }

    }
    
    public void atualizarFuncionario(Funcionario funcionario) throws SQLException {
    String sql = "UPDATE funcionario SET nome=?, CPF=?, RG=?, idade=? WHERE id_funcionario=?";

    try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
        ps.setString(1, funcionario.getNome());
        ps.setString(2, funcionario.getCPF());
        ps.setString(3, funcionario.getRG());
        ps.setInt(4, funcionario.getIdade());
        ps.setInt(5, funcionario.getId_funcionario());

        int linhasAfetadas = ps.executeUpdate();

        if (linhasAfetadas > 0) {
            System.out.println("Funcionário atualizado com sucesso!");
        } else {
            System.out.println("Nenhum funcionário atualizado. Verifique se o ID é válido.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    
    public void deletarFuncionario(int idFuncionario) throws SQLException {
        String sql = "DELETE FROM FUNCIONARIO WHERE id_funcionario = ?";

        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setInt(1, idFuncionario);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public ArrayList<Funcionario> PesquisarFuncionario(){
        String sql = "SELECT * FROM FUNCIONARIO";
        
        PreparedStatement ps = null;
        
        try{
        ps = Conexao.getConexao().prepareStatement(sql);
        rs = ps.executeQuery();
        
        while(rs.next()){
            Funcionario funcionario = new Funcionario();
            funcionario.setId_funcionario(rs.getInt("id_funcionario"));
            funcionario.setNome(rs.getString("nome"));
            funcionario.setCPF(rs.getString("CPF"));
            funcionario.setRG(rs.getString("RG"));
            funcionario.setIdade(rs.getInt("idade"));
            funcionario.setData_criacao(rs.getDate("data_criacao"));
            
            
            lista.add(funcionario);
        }
        
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return lista;
    }
}