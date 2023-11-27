package DAO;

import com.mycompany.biblioteca.Reserva;
import com.mycompany.conexoes.Conexao;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ReservaDAO {
    
        ResultSet rs;
        ArrayList<Reserva> lista = new ArrayList<>();
    
        public void cadastrarReserva(Reserva reserva) throws SQLException{
        String sql = "INSERT INTO RESERVA (id_funcionario, id_cliente, id_livro, status, datainicio, datafim) values (?, ?, ?, ?, ?, ?)";
        
        PreparedStatement ps = null;
        
        try{
        ps = Conexao.getConexao().prepareStatement(sql);
        ps.setInt(1, reserva.getId_funcionario());
        ps.setInt(2, reserva.getId_cliente());
        ps.setInt(3, reserva.getId_livro());
        ps.setString(4,reserva.getStatus());
        ps.setDate(5, new java.sql.Date(reserva.getDatainicio().getTime()));
        ps.setDate(6, new java.sql.Date(reserva.getDatafim().getTime()));
        
        
        ps.execute();
        ps.close();
        
        }catch(SQLException e){
            e.printStackTrace();
        } 
    }
        
        public void atualizarReserva(Reserva reserva) throws SQLException {
    String sql = "UPDATE reserva SET id_funcionario=?, id_cliente=?, id_livro=?, status=?, datainicio=?, datafim=? WHERE id_reserva=?";

    try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
        ps.setInt(1, reserva.getId_funcionario());
        ps.setInt(2, reserva.getId_cliente());
        ps.setInt(3, reserva.getId_livro());
        ps.setString(4, reserva.getStatus());
        ps.setDate(5, (Date) reserva.getDatainicio());
        ps.setDate(6, (Date) reserva.getDatafim());
        ps.setInt(7, reserva.getId_reserva());


        int linhasAfetadas = ps.executeUpdate();

        if (linhasAfetadas > 0) {
            JOptionPane.showMessageDialog(null, "Reserva atualizado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum reserva atualizado. Verifique se o ID é válido.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
        public void atualizarStatus(Reserva reserva) throws SQLException {
    String sql = "UPDATE reserva SET status=? WHERE id_reserva=?";

    try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
        ps.setString(1, reserva.getStatus());
        ps.setInt(2, reserva.getId_reserva());


        int linhasAfetadas = ps.executeUpdate();

        if (linhasAfetadas > 0) {
            JOptionPane.showMessageDialog(null, "Reserva atualizado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum reserva atualizado. Verifique se o ID é válido.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
        
        public Reserva pesquisarReservaPorID(int idReserva) throws SQLException {
        String sql = "SELECT * FROM reserva WHERE id_reserva LIKE ?";
        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setInt(1, idReserva);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                                Reserva reserva = new Reserva();
                                reserva.setId_reserva(rs.getInt("id_reserva"));
                                reserva.setId_funcionario(rs.getInt("id_funcionario"));
                                reserva.setId_cliente(rs.getInt("id_cliente"));
                                reserva.setId_livro(rs.getInt("id_livro"));
                                reserva.setStatus(rs.getString("status"));
                                reserva.setDatainicio(rs.getDate("datainicio"));
                                reserva.setDatafim(rs.getDate("datafim"));
                                reserva.setDatacadastro(rs.getDate("data_criacao"));


                    return reserva;

                } else {
                    System.out.println("Nenhuma reserva encontrado com esse id: " + idReserva);
                    return null;
                }

            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }

    }
        
        public void deletarReserva(int idReserva) throws SQLException {
        String sql = "DELETE FROM RESERVA WHERE id_reserva = ?";

        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setInt(1, idReserva);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        
        public void atualizarStatusReserva(int idReserva, String novoStatus) throws SQLException {
        String sql = "UPDATE RESERVA SET status = ? WHERE id_reserva = ?";

        try (PreparedStatement ps = Conexao.getConexao().prepareStatement(sql)) {
            ps.setString(1, novoStatus);
            ps.setInt(2, idReserva);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        
        
        
       public ArrayList<Reserva> listarReservas(){
        String sql = "SELECT * FROM Reserva";
        
        PreparedStatement ps = null;
        
        try{
        ps = Conexao.getConexao().prepareStatement(sql);
        rs = ps.executeQuery();
        
        while(rs.next()){
            Reserva reserva = new Reserva();
            reserva.setId_reserva(rs.getInt("id_reserva"));
            reserva.setId_funcionario(rs.getInt("id_funcionario"));
            reserva.setId_cliente(rs.getInt("id_cliente"));
            reserva.setId_livro(rs.getInt("id_livro"));
            reserva.setStatus(rs.getString("status"));
            reserva.setDatainicio(rs.getDate("datainicio"));
            reserva.setDatafim(rs.getDate("datafim"));
            reserva.setDatacadastro(rs.getDate("data_criacao"));
            
            
            lista.add(reserva);
        }
        
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return lista;
    }
       
       public ArrayList<Reserva> listarReservasPorCliente(int idCliente){
        String sql = "SELECT * FROM Reserva WHERE id_cliente = ?";
        
        PreparedStatement ps = null;
        
        try{
        ps = Conexao.getConexao().prepareStatement(sql);
        ps.setInt(1, idCliente);
        rs = ps.executeQuery();
        
        while(rs.next()){
            Reserva reserva = new Reserva();
            reserva.setId_reserva(rs.getInt("id_reserva"));
            reserva.setId_funcionario(rs.getInt("id_funcionario"));
            reserva.setId_cliente(rs.getInt("id_cliente"));
            reserva.setId_livro(rs.getInt("id_livro"));
            reserva.setStatus(rs.getString("status"));
            reserva.setDatainicio(rs.getDate("datainicio"));
            reserva.setDatafim(rs.getDate("datafim"));
            reserva.setDatacadastro(rs.getDate("data_criacao"));
            
            
            lista.add(reserva);
        }
        
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return lista;
    }   
       
       public ArrayList<Reserva> listarReservasPorClienteStatus(int idCliente){
        String sql = "SELECT * FROM Reserva WHERE id_cliente = ? AND status = ?";
        
        PreparedStatement ps = null;
        
        try{
        ps = Conexao.getConexao().prepareStatement(sql);
        ps.setInt(1, idCliente);
        ps.setString(2, "Devolvido");
        rs = ps.executeQuery();
        
        while(rs.next()){
            Reserva reserva = new Reserva();
            reserva.setId_reserva(rs.getInt("id_reserva"));
            reserva.setId_funcionario(rs.getInt("id_funcionario"));
            reserva.setId_cliente(rs.getInt("id_cliente"));
            reserva.setId_livro(rs.getInt("id_livro"));
            reserva.setStatus(rs.getString("status"));
            reserva.setDatainicio(rs.getDate("datainicio"));
            reserva.setDatafim(rs.getDate("datafim"));
            reserva.setDatacadastro(rs.getDate("data_criacao"));
            
            
            lista.add(reserva);
        }
        
        }catch(SQLException e){
            e.printStackTrace();
        }
        
        return lista;
    }   
}
