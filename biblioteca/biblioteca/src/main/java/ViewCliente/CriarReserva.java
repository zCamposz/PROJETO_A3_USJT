package ViewCliente;

import ViewFuncionario.*;
import DAO.CategoriaDAO;
import DAO.ClienteDAO;
import DAO.LivroDAO;
import DAO.ReservaDAO;
import com.mycompany.biblioteca.Categoria;
import com.mycompany.biblioteca.Cliente;
import com.mycompany.biblioteca.Funcionario;
import com.mycompany.biblioteca.Livro;
import com.mycompany.biblioteca.Reserva;
import static java.lang.System.exit;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class CriarReserva extends javax.swing.JFrame {
    
    private static Cliente cliente;
    
    public CriarReserva(Cliente cliente) {
        initComponents();
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        this.cliente = cliente;
        ComboBoxLivros();
    }
    
    private void ComboBoxLivros() {
        LivroDAO livroDAO = new LivroDAO();

        // Obtenha a lista de livros do banco de dados
        ArrayList<Livro> listaLivros = livroDAO.listarLivros();

        // Crie um vetor com os nomes dos livros
        String[] nomesLivros = new String[listaLivros.size()];
        for (int i = 0; i < listaLivros.size(); i++) {
            nomesLivros[i] = listaLivros.get(i).getDescricao();
        }

        // Configure o modelo do JComboBox com o vetor de nomes dos livros
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(nomesLivros));
    }
    
    
    private void atualizarValor() {
    try {
        // Obtenha o livro selecionado no JComboBox
        String nomeLivroSelecionado = jComboBox1.getSelectedItem().toString();

        // Obtenha o livro do banco de dados
        LivroDAO livroDAO = new LivroDAO();
        Livro livroSelecionado = livroDAO.pesquisarLivroPorNome(nomeLivroSelecionado);

        campoValor.setText(String.valueOf(livroSelecionado.getValor()));
        
    } catch (SQLException erro) {
        JOptionPane.showMessageDialog(null, "Erro ao obter informações do livro: " + erro);
    }
}
    
    private void atualizarCategoria() {
    try {
        // Obtenha o livro selecionado no JComboBox
        String nomeLivroSelecionado = jComboBox1.getSelectedItem().toString();

        // Obtenha o livro do banco de dados
        LivroDAO livroDAO = new LivroDAO();
        Livro livroSelecionado = livroDAO.pesquisarLivroPorNome(nomeLivroSelecionado);
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        Categoria categoria = categoriaDAO.pesquisarCategoriaPorID(livroSelecionado.getId_categoria());
        
        campoCategoria.setText(String.valueOf(categoria.getNome()));
        
    } catch (SQLException erro) {
        JOptionPane.showMessageDialog(null, "Erro ao obter informações do livro: " + erro);
    }
}
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        campoValor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        campoCategoria = new javax.swing.JTextField();
        JLabel = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnCadastrar = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        JLabel1 = new javax.swing.JLabel();
        campoDataInicio = new javax.swing.JTextField();
        campoDatafim = new javax.swing.JTextField();
        JLabel2 = new javax.swing.JLabel();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Nome Livro:");

        campoValor.setEditable(false);
        campoValor.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        campoValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoValorActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Valor:");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Reserva de Livro");

        campoCategoria.setEditable(false);
        campoCategoria.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        JLabel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        JLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLabel.setText("Categoria:");

        btnCancelar.setText("Voltar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        JLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        JLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLabel1.setText("Data Inicio:");

        campoDataInicio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        campoDatafim.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        JLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        JLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLabel2.setText("Data Fim:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(478, 478, 478)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(campoCategoria, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoDatafim, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoDataInicio, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(campoValor, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoValor, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoDatafim, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
            ConsultaReserva consultaReserva = new ConsultaReserva(cliente);
            consultaReserva.setVisible(true);
            this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void campoValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoValorActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
            
        try{
        
            String nomeLivro;
            int idCliente, idLivro;
            Date dataInicioReserva, dataFimReserva;
            
            nomeLivro = jComboBox1.getSelectedItem().toString();
           
                        
            SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
            
            dataInicioReserva = formatoData.parse(campoDataInicio.getText());
            dataFimReserva = formatoData.parse(campoDatafim.getText());
            
            Reserva reserva = new Reserva();
            ReservaDAO reservaDAO = new ReservaDAO();
            LivroDAO livroDAO = new LivroDAO();
            Livro livro = livroDAO.pesquisarLivroPorNome(nomeLivro);
            
            
            idCliente = cliente.getId_cliente();
            idLivro = livro.getId_livro();
            
            reserva.setId_funcionario(2);
            reserva.setId_cliente(idCliente);
            reserva.setId_livro(idLivro);
            reserva.setStatus("Novo");
            reserva.setDatainicio(dataInicioReserva);
            reserva.setDatafim(dataFimReserva);
            
            reservaDAO.cadastrarReserva(reserva);
            
            
        }   catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Cadastrar reserva: " + erro);
                return;
        }   catch (NumberFormatException erro){
                JOptionPane.showMessageDialog(null, erro);
                return;
        }catch (ParseException erro) {
        JOptionPane.showMessageDialog(null, "Erro ao converter a data: " + erro.getMessage());
        return;
        }
        
        JOptionPane.showMessageDialog(null, "Cadastrado a reserva com sucesso!");
            ConsultaReserva consultaReserva = new ConsultaReserva(cliente);
            consultaReserva.setVisible(true);
            this.setVisible(false);
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
       atualizarValor();
       atualizarCategoria();
    }//GEN-LAST:event_jComboBox1ActionPerformed


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CriarReserva(cliente).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabel;
    private javax.swing.JLabel JLabel1;
    private javax.swing.JLabel JLabel2;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JTextField campoCategoria;
    private javax.swing.JTextField campoDataInicio;
    private javax.swing.JTextField campoDatafim;
    private javax.swing.JTextField campoValor;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuItem jMenuItem1;
    // End of variables declaration//GEN-END:variables
}
