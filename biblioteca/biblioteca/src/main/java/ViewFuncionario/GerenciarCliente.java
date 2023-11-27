package ViewFuncionario;

import DAO.ClienteDAO;
import com.mycompany.biblioteca.Funcionario;
import DAO.FuncionarioDAO;
import com.mycompany.biblioteca.Cliente;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class GerenciarCliente extends javax.swing.JFrame {

    private static Funcionario funcionario;
    
    public GerenciarCliente(Funcionario funcionario) {
        initComponents();
        this.funcionario = funcionario;
        consultarClientes();
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        refreshFuncionarios = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        consultaClientes = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        refreshFuncionarios.setText("Refresh");
        refreshFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshFuncionariosActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel1.setText("Consulta de Clientes");

        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        consultaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Cliente", "Nome", "CPF", "RG", "Idade", "Data de Criacao"
            }
        ));
        jScrollPane2.setViewportView(consultaClientes);

        jButton3.setText("Criar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Atualizar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(refreshFuncionarios)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 319, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(340, 340, 340))
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(9, 9, 9))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(refreshFuncionarios))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap(149, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void refreshFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshFuncionariosActionPerformed
        // TODO add your handling code here:
        consultarClientes();
    }//GEN-LAST:event_refreshFuncionariosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        CentralFuncionario centralFuncionario = new CentralFuncionario(funcionario);
        centralFuncionario.setVisible(true);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        CriarCliente criarCliente = new CriarCliente(funcionario);
        criarCliente.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Cliente clienteSelecionado = clienteSelecionado();
            if (clienteSelecionado != null) {
                AtualizarCliente atualizarCliente = new AtualizarCliente(funcionario, clienteSelecionado);
                atualizarCliente.setVisible(true);
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "Nenhum cliente selecionado.");
    }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void deletarFuncionario(int idFuncionario) {
        try {
            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
            funcionarioDAO.deletarFuncionario(idFuncionario);

            consultarClientes();

            JOptionPane.showMessageDialog(this, "Funcionario deletado com sucesso.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao deletar o funcionario: " + ex.getMessage());
        }
    }
    
    
    private Cliente clienteSelecionado() {
            try {
                int selectedRow = consultaClientes.getSelectedRow();
                if (selectedRow != -1) {
                    int idCliente = (int) consultaClientes.getValueAt(selectedRow, 0);
                    // Chame seu método para obter o Funcionario com base no ID (por exemplo, PesquisarFuncionarioPorID)
                    ClienteDAO clienteDAO = new ClienteDAO();
                    return clienteDAO.pesquisarClientePorID(idCliente);
                }
                return null;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
}
    
    private void consultarClientes(){
        try{
           ClienteDAO clienteDAO = new ClienteDAO();
           
           
           
           DefaultTableModel model = (DefaultTableModel) consultaClientes.getModel();
           model.setNumRows(0);
           
            ArrayList<Cliente> lista = clienteDAO.listarClientes();
            
            for(int i = 0; i < lista.size(); i++){
                model.addRow(new Object[]{
                    lista.get(i).getId_cliente(),
                    lista.get(i).getNome(),
                    lista.get(i).getCPF(),
                    lista.get(i).getRG(),
                    lista.get(i).getIdade(),  
                    lista.get(i).getData_criacao()
                });
            }
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Listar Valores: " + e);
        }
        
    }
    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GerenciarCliente(funcionario).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable consultaClientes;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton refreshFuncionarios;
    // End of variables declaration//GEN-END:variables
}
