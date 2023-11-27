package DAO;

import com.mycompany.biblioteca.Cliente;
import com.mycompany.biblioteca.Funcionario;
import com.mycompany.biblioteca.Usuario;
import com.mycompany.conexoes.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class UsuarioDAO {

    ResultSet rs;

    public int getNextId() throws SQLException {
        String sql = "SELECT MAX(id_login) + 1 FROM login";
        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        }
        throw new SQLException("Falha ao obter prÃ³ximo ID para login.");
    }

    public void cadastrarUsuario(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO LOGIN (id_login, login, senha) values (?, ?, ?)";

        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, getNextId());
            ps.setString(2, usuario.getLogin());
            ps.setString(3, usuario.getSenha());

            ps.execute();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Usuario fazerLogin(String login) throws SQLException {
        String sql = "SELECT * FROM login WHERE login LIKE ?";
        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setString(1, login);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Usuario usuario = new Usuario();
                    usuario.setId_login(rs.getInt("id_login"));
                    usuario.setSenha(rs.getString("senha"));
                    usuario.setLogin(rs.getString("login"));

                    return usuario;

                } else {
                    System.out.println("Nenhum usuario encontrado para o login: " + login);
                    return null;
                }

            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }

    }
    
    
   public Funcionario loginFuncionario(int id_login) throws SQLException {
    String sql = "SELECT * FROM funcionario WHERE id_login LIKE ?";
    
    try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
        ps.setInt(1, id_login);

        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setId_funcionario(rs.getInt("id_funcionario"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setCPF(rs.getString("CPF"));
                funcionario.setRG(rs.getString("RG")); // Adiciona o tipo ao usuÃ¡rio
                funcionario.setIdade(rs.getInt("idade"));
                funcionario.setData_criacao(rs.getDate("data_criacao"));
                funcionario.setId_login(rs.getInt("id_login"));


                    return funcionario;

                } else {
                    JOptionPane.showMessageDialog(null, "Seu usuario não foi encontrado, tente logar como cliente");
                    return null;
                }

            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
}
        
    
    public Cliente loginCliente(int id_login) throws SQLException {
    String sql = "SELECT * FROM cliente WHERE id_login LIKE ?";
    
    try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
        ps.setInt(1, id_login);

        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId_cliente(rs.getInt("id_cliente"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCPF(rs.getString("CPF"));
                cliente.setRG(rs.getString("RG")); // Adiciona o tipo ao usuÃ¡rio
                cliente.setIdade(rs.getInt("idade"));
                cliente.setData_criacao(rs.getDate("data_criacao"));
                cliente.setId_login(rs.getInt("id_login"));


                    return cliente;

                } else {
                    JOptionPane.showMessageDialog(null, "Seu usuario não foi encontrado, tente logar como funcionario");
                    return null;
                }

            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
}

    
    

}
