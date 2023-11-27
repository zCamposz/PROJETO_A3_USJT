package DAO;

import com.mycompany.biblioteca.Cliente;
import com.mycompany.biblioteca.Funcionario;
import com.mycompany.conexoes.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author joaov
 */
public class ClienteDAO {
    
    ResultSet rs;
    ArrayList<Cliente> lista = new ArrayList<>();
        
    public void cadastrarCliente(Cliente cliente) throws SQLException{
        String sql = "INSERT INTO CLIENTE (nome, cpf, rg, idade, id_login) values (?, ?, ?, ?, ?)";
        
        PreparedStatement ps = null;
        
        try{
        ps = Conexao.getConexao().prepareStatement(sql);
        ps.setString(1,cliente.getNome());
        ps.setString(2, cliente.getCPF());
        ps.setString(3, cliente.getRG());
        ps.setInt(4, cliente.getIdade());
        ps.setInt(5, cliente.getId_login());
        
        
        ps.execute();
        ps.close();
        
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        
    }
    
    public void atualizarCliente(Cliente cliente) throws SQLException {
    String sql = "UPDATE cliente SET nome=?, CPF=?, RG=?, idade=? WHERE id_cliente=?";

    try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
        ps.setString(1, cliente.getNome());
        ps.setString(2, cliente.getCPF());
        ps.setString(3, cliente.getRG());
        ps.setInt(4, cliente.getIdade());
        ps.setInt(5, cliente.getId_cliente());

        int linhasAfetadas = ps.executeUpdate();

        if (linhasAfetadas > 0) {
            System.out.println("Cliente atualizado com sucesso!");
        } else {
            System.out.println("Nenhum cliente atualizado. Verifique se o ID é válido.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    
    
        public Cliente pesquisarClientePorNome(String nomeCliente) throws SQLException {
        String sql = "SELECT * FROM cliente WHERE nome LIKE ?";
        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setString(1, nomeCliente);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                                Cliente cliente = new Cliente();
                                cliente.setId_cliente(rs.getInt("id_cliente"));
                                cliente.setNome(rs.getString("nome"));
                                cliente.setCPF(rs.getString("CPF"));
                                cliente.setRG(rs.getString("RG"));
                                cliente.setIdade(rs.getInt("idade"));
                                cliente.setData_criacao(rs.getDate("data_criacao"));


                    return cliente;

                } else {
                    System.out.println("Nenhum funcionario encontrado com esse id: " + nomeCliente);
                    return null;
                }

            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }

    }
        
        
        public Cliente pesquisarClientePorID(int idCliente) throws SQLException {
        String sql = "SELECT * FROM cliente WHERE id_cliente LIKE ?";
        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setInt(1, idCliente);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                                Cliente cliente = new Cliente();
                                cliente.setId_cliente(rs.getInt("id_cliente"));
                                cliente.setNome(rs.getString("nome"));
                                cliente.setCPF(rs.getString("CPF"));
                                cliente.setRG(rs.getString("RG"));
                                cliente.setIdade(rs.getInt("idade"));
                                cliente.setData_criacao(rs.getDate("data_criacao"));


                    return cliente;

                } else {
                    System.out.println("Nenhum funcionario encontrado com esse id: " + idCliente);
                    return null;
                }

            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }

    }
    
    
        public ArrayList<Cliente> listarClientes(){
        String sql = "SELECT * FROM CLIENTE";
        
        PreparedStatement ps = null;
        
        try{
        ps = Conexao.getConexao().prepareStatement(sql);
        rs = ps.executeQuery();
        
        while(rs.next()){
            Cliente cliente = new Cliente();
            cliente.setId_cliente(rs.getInt("id_cliente"));
            cliente.setNome(rs.getString("nome"));
            cliente.setCPF(rs.getString("CPF"));
            cliente.setRG(rs.getString("RG"));
            cliente.setIdade(rs.getInt("idade"));
            cliente.setData_criacao(rs.getDate("data_criacao"));
            
            
            lista.add(cliente);
        }
        
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return lista;
    }
}
