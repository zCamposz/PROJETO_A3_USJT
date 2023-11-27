package ViewFuncionario;

import DAO.ClienteDAO;
import DAO.FuncionarioDAO;
import DAO.LivroDAO;
import com.mycompany.biblioteca.Funcionario;
import DAO.ReservaDAO;
import com.mycompany.biblioteca.Cliente;
import com.mycompany.biblioteca.Livro;
import com.mycompany.biblioteca.Reserva;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GerenciarReserva extends javax.swing.JFrame {

    private static Funcionario funcionario;
    private javax.swing.JTable tabelaReservas;
    
    public GerenciarReserva(Funcionario funcionario) {
        initComponents();
        this.funcionario = funcionario;
        tabelaReservas = consultaReserva;
        consultarReservas();
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        consultaReserva = new javax.swing.JTable();
        refreshReservas = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        pesquisarFuncionarios1 = new javax.swing.JButton();
        pesquisarFuncionarios2 = new javax.swing.JButton();
        pesquisarFuncionarios3 = new javax.swing.JButton();
        pesquisarFuncionarios4 = new javax.swing.JButton();
        pesquisarFuncionarios5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        consultaReserva.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Reserva", "Nome Funcionario", "Nome Cliente", "Nome Livro", "Status", "Data de Inicio", "Data fim", "Data da Solicitação"
            }
        ));
        jScrollPane1.setViewportView(consultaReserva);

        refreshReservas.setText("Refresh");
        refreshReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshReservasActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel1.setText("Consulta de Reserva");

        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        pesquisarFuncionarios1.setText("Criar");
        pesquisarFuncionarios1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarFuncionarios1ActionPerformed(evt);
            }
        });

        pesquisarFuncionarios2.setText("Deletar");
        pesquisarFuncionarios2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarFuncionarios2ActionPerformed(evt);
            }
        });

        pesquisarFuncionarios3.setText("Emprestar");
        pesquisarFuncionarios3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarFuncionarios3ActionPerformed(evt);
            }
        });

        pesquisarFuncionarios4.setText("Devolvido");
        pesquisarFuncionarios4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarFuncionarios4ActionPerformed(evt);
            }
        });

        pesquisarFuncionarios5.setText("Atualizar");
        pesquisarFuncionarios5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarFuncionarios5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(refreshReservas)
                .addGap(274, 274, 274)
                .addComponent(jLabel1)
                .addContainerGap(388, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(pesquisarFuncionarios2)
                                .addGap(18, 18, 18)
                                .addComponent(pesquisarFuncionarios5)
                                .addGap(18, 18, 18)
                                .addComponent(pesquisarFuncionarios1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(pesquisarFuncionarios4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pesquisarFuncionarios3)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(refreshReservas))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pesquisarFuncionarios1)
                    .addComponent(pesquisarFuncionarios2)
                    .addComponent(jButton1)
                    .addComponent(pesquisarFuncionarios5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pesquisarFuncionarios3)
                    .addComponent(pesquisarFuncionarios4))
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void refreshReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshReservasActionPerformed
        // TODO add your handling code here:
        consultarReservas();
    }//GEN-LAST:event_refreshReservasActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        CentralFuncionario centralFuncionario = new CentralFuncionario(funcionario);
        centralFuncionario.setVisible(true);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void pesquisarFuncionarios1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarFuncionarios1ActionPerformed
        // TODO add your handling code here:
            CriarReserva reservaFuncionario = new CriarReserva(funcionario);
            reservaFuncionario.setVisible(true);
            this.setVisible(false);
    }//GEN-LAST:event_pesquisarFuncionarios1ActionPerformed

    private void pesquisarFuncionarios2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarFuncionarios2ActionPerformed
       
            int selectedRow = tabelaReservas.getSelectedRow();
            
            if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Nenhuma reserva selecionada.");
            return;
            }
          
            int idReserva = (int) tabelaReservas.getValueAt(selectedRow, 0);

            
            deletarReserva(idReserva);
    }//GEN-LAST:event_pesquisarFuncionarios2ActionPerformed

    private void pesquisarFuncionarios3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarFuncionarios3ActionPerformed
        // TODO add your handling code here:
        int selectedRow = tabelaReservas.getSelectedRow();
        
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Nenhuma reserva selecionada.");
            return;
        }
        
        int idReserva = (int) tabelaReservas.getValueAt(selectedRow, 0);
        
        String novoStatus = "Em andamento";
        
        novoStatus(idReserva, novoStatus);
    }//GEN-LAST:event_pesquisarFuncionarios3ActionPerformed

    private void pesquisarFuncionarios4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarFuncionarios4ActionPerformed
        // TODO add your handling code here:
        int selectedRow = tabelaReservas.getSelectedRow();
        
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Nenhuma reserva selecionada.");
            return;
        }
        
        int idReserva = (int) tabelaReservas.getValueAt(selectedRow, 0);
        
        String novoStatus = "Devolvido";
        
        novoStatus(idReserva, novoStatus);
    }//GEN-LAST:event_pesquisarFuncionarios4ActionPerformed

    private void pesquisarFuncionarios5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarFuncionarios5ActionPerformed
        // TODO add your handling code here:
        Reserva reserva = reservaSelecionado();
            if (reserva != null) {
                AtualizarReserva atualizarReserva = new AtualizarReserva(funcionario, reserva);
                atualizarReserva.setVisible(true);
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "Nenhuma reserva selecionada.");
    }
    }//GEN-LAST:event_pesquisarFuncionarios5ActionPerformed

    private Reserva reservaSelecionado() {
            try {
                int selectedRow = consultaReserva.getSelectedRow();
                if (selectedRow != -1) {
                    int idReserva = (int) consultaReserva.getValueAt(selectedRow, 0);
                    // Chame seu método para obter o Funcionario com base no ID (por exemplo, PesquisarFuncionarioPorID)
                    ReservaDAO reservaDAO = new ReservaDAO();
                    return reservaDAO.pesquisarReservaPorID(idReserva);
                }
                return null;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
}
    
    private void deletarReserva(int idReserva) {
        try {
            ReservaDAO reservaDAO = new ReservaDAO();
            reservaDAO.deletarReserva(idReserva);

            consultarReservas();

            JOptionPane.showMessageDialog(this, "Reserva deletada com sucesso.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao deletar a reserva: " + ex.getMessage());
        }
    }
    
    private void novoStatus(int idReserva, String novoStatus) {
        try {
            ReservaDAO reservaDAO = new ReservaDAO();
            reservaDAO.atualizarStatusReserva(idReserva, novoStatus);

            consultarReservas();

            JOptionPane.showMessageDialog(this, "Emprestimo iniciado.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao mudar os status da reserva: " + ex.getMessage());
        }
    }
    
    private void consultarReservas(){
        try{
           ReservaDAO reservaDAO = new ReservaDAO();
           FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
           ClienteDAO clienteDAO = new ClienteDAO();
           LivroDAO livroDAO = new LivroDAO();
           
           
           DefaultTableModel model = (DefaultTableModel) consultaReserva.getModel();
           model.setNumRows(0);
           
            ArrayList<Reserva> lista = reservaDAO.listarReservas();
            
            
            
            for(int i = 0; i < lista.size(); i++){
                
                Funcionario funcionario = funcionarioDAO.pesquisarFuncionarioPorID(lista.get(i).getId_funcionario());
                Cliente cliente = clienteDAO.pesquisarClientePorID(lista.get(i).getId_cliente());
                Livro livro = livroDAO.pesquisarLivroPorID(lista.get(i).getId_livro());
                
                model.addRow(new Object[]{
                    lista.get(i).getId_reserva(),
                    (funcionario != null) ? funcionario.getNome() : "",
                    (cliente != null) ? cliente.getNome() : "",
                    (livro != null) ? livro.getDescricao() : "",
                    lista.get(i).getStatus(),
                    lista.get(i).getDatainicio(),
                    lista.get(i).getDatafim(),
                    lista.get(i).getDatacadastro(),
                });
            }
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Listar Valores: " + e);
        }
        
    }
    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GerenciarReserva(funcionario).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable consultaReserva;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton pesquisarFuncionarios1;
    private javax.swing.JButton pesquisarFuncionarios2;
    private javax.swing.JButton pesquisarFuncionarios3;
    private javax.swing.JButton pesquisarFuncionarios4;
    private javax.swing.JButton pesquisarFuncionarios5;
    private javax.swing.JButton refreshReservas;
    // End of variables declaration//GEN-END:variables
}
