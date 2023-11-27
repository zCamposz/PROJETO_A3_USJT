package ViewCliente;

import ViewFuncionario.*;
import DAO.CategoriaDAO;
import DAO.ClienteDAO;
import com.mycompany.biblioteca.Funcionario;
import DAO.FuncionarioDAO;
import DAO.LivroDAO;
import com.mycompany.biblioteca.Categoria;
import com.mycompany.biblioteca.Cliente;
import com.mycompany.biblioteca.Livro;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ConsultaLivro extends javax.swing.JFrame {

    private static Cliente cliente;
    
    public ConsultaLivro(Cliente cliente) {
        initComponents();
        this.cliente = cliente;
        consultarLivros();
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        refreshFuncionarios = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        consultaLivro = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        refreshFuncionarios.setText("Refresh");
        refreshFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshFuncionariosActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel1.setText("Consulta de Livros");

        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        consultaLivro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Livro", "Titulo", "Valor", "Nota", "Data de Criacao", "Categoria"
            }
        ));
        jScrollPane2.setViewportView(consultaLivro);

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 347, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(340, 340, 340))
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jButton1)
                .addGap(9, 924, Short.MAX_VALUE))
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
                .addComponent(jButton1)
                .addContainerGap(149, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void refreshFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshFuncionariosActionPerformed
        // TODO add your handling code here:
        consultarLivros();
    }//GEN-LAST:event_refreshFuncionariosActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        CentralCliente centralCliente = new CentralCliente(cliente);
        centralCliente.setVisible(true);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    
    
    private Livro livroSelecionado() {
            try {
                int selectedRow = consultaLivro.getSelectedRow();
                if (selectedRow != -1) {
                    int idLivro = (int) consultaLivro.getValueAt(selectedRow, 0);
                    // Chame seu método para obter o Funcionario com base no ID (por exemplo, PesquisarFuncionarioPorID)
                    LivroDAO livroDAO = new LivroDAO();
                    return livroDAO.pesquisarLivroPorID(idLivro);
                }
                return null;
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
}
    
    private void consultarLivros(){
        try{
           LivroDAO livroDAO = new LivroDAO();
           CategoriaDAO categoriaDAO = new CategoriaDAO();
           
           
           DefaultTableModel model = (DefaultTableModel) consultaLivro.getModel();
           model.setNumRows(0);
           
            ArrayList<Livro> lista = livroDAO.listarLivros();
            
            for(int i = 0; i < lista.size(); i++){
                
            Categoria categoria = categoriaDAO.pesquisarCategoriaPorID(lista.get(i).getId_categoria()); 
                
                model.addRow(new Object[]{
                    lista.get(i).getId_livro(),
                    lista.get(i).getDescricao(),
                    lista.get(i).getValor(),
                    lista.get(i).getNota(),
                    lista.get(i).getData_criacao(),
                    (categoria != null) ? categoria.getNome() : "",
                });
            }
            
        }catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Listar Valores: " + e);
        }
        
    }
    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaLivro(cliente).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable consultaLivro;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton refreshFuncionarios;
    // End of variables declaration//GEN-END:variables
}
