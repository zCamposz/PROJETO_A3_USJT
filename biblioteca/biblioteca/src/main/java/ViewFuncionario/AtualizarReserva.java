package ViewFuncionario;

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

public class AtualizarReserva extends javax.swing.JFrame {
    
    private static Funcionario funcionario;
    private static Reserva reserva;
    private SimpleDateFormat formatoData;
    
    public AtualizarReserva(Funcionario funcionario, Reserva reserva) {
        initComponents();
        
        
        this.funcionario = funcionario;
        this.reserva = reserva;
        this.formatoData = new SimpleDateFormat("dd/MM/yyyy");
        
        int idLivro = reserva.getId_livro();
        int idReserva = reserva.getId_reserva();
        int idCliente = reserva.getId_cliente();
        String status = reserva.getStatus();
        
        Livro livro = pesquisarLivroID(idLivro);
        Cliente cliente = pesquisarClienteID(idCliente);
        //Reserva reserva = pesquisarReservaID(idReserva);
        ComboBoxLivros();
        ComboBoxClientes();
        
        jComboBox1.setSelectedItem(livro.getDescricao());
        jComboBox2.setSelectedItem(cliente.getNome());
        jComboBox3.setSelectedItem(status);
        
        configurarCamposData(reserva.getDatainicio(), reserva.getDatafim());
        
        


    }
    
    private void configurarCamposData(Date datainicio, Date datafim) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        campoDataInicio.setText(sdf.format(datainicio));
        campoDatafim.setText(sdf.format(datafim));
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
    
    private void ComboBoxClientes() {
        ClienteDAO clienteDAO = new ClienteDAO();

        // Obtenha a lista de livros do banco de dados
        ArrayList<Cliente> listaClientes = clienteDAO.listarClientes();

        // Crie um vetor com os nomes dos livros
        String[] nomesClientes = new String[listaClientes.size()];
        for (int i = 0; i < listaClientes.size(); i++) {
            nomesClientes[i] = listaClientes.get(i).getNome();
        }

        // Configure o modelo do JComboBox com o vetor de nomes dos livros
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(nomesClientes));
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
    
    private Livro pesquisarLivroID(int idLivro){
        try{
        LivroDAO livroDAO = new LivroDAO();
        Livro livro = livroDAO.pesquisarLivroPorID(idLivro);
        
        
        return livro;
        } catch (SQLException erro) {
        JOptionPane.showMessageDialog(null, "Erro ao obter informações do livro: " + erro);
        return null;
        }
    }
    
    private Cliente pesquisarClienteID(int idCliente){
        try{
        ClienteDAO clienteDAO = new ClienteDAO();
        Cliente cliente = clienteDAO.pesquisarClientePorID(idCliente);
        
        
        return cliente;
        } catch (SQLException erro) {
        JOptionPane.showMessageDialog(null, "Erro ao obter informações do livro: " + erro);
        return null;
        }
    }
    
    /*private Reserva pesquisarReservaID(int idReserva){
        try{
        ReservaDAO reservaDAO = new ReservaDAO();
        Reserva reserva = reservaDAO.pesquisarReservaPorID(idReserva);
        
        
        return reserva;
        } catch (SQLException erro) {
        JOptionPane.showMessageDialog(null, "Erro ao obter informações do livro: " + erro);
        return null;
        }
    }*/
    
    
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
        JLabel3 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        JLabel4 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();

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
        jLabel3.setText("Atualizar Reserva");

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

        btnCadastrar.setText("Atualizar");
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

        JLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        JLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLabel3.setText("Nome Cliente:");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        JLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        JLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLabel4.setText("Status");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Novo", "Em andamento", "Devolvido", "Encerrado" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
            .addGroup(layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(campoValor, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(24, 24, 24)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(campoDatafim, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(campoCategoria, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(campoDataInicio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBox3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(122, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoValor, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoDatafim, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 88, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
            GerenciarReserva gerenciarReserva = new GerenciarReserva(funcionario);
            gerenciarReserva.setVisible(true);
            this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void campoValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoValorActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
            
        try{
        
            String nomeLivro, nomeCliente, status;
            int idFuncionario, idCliente, idLivro, idReserva;
            
            nomeLivro = jComboBox1.getSelectedItem().toString();
            idFuncionario = funcionario.getId_funcionario();
            nomeCliente = jComboBox2.getSelectedItem().toString();
            status = jComboBox3.getSelectedItem().toString();
            
          
                        
            java.sql.Date dataInicioReserva = new java.sql.Date(formatoData.parse(campoDataInicio.getText()).getTime());
            java.sql.Date dataFimReserva = new java.sql.Date(formatoData.parse(campoDatafim.getText()).getTime());
            
            ReservaDAO reservaDAO = new ReservaDAO();
            LivroDAO livroDAO = new LivroDAO();
            Livro livro = livroDAO.pesquisarLivroPorNome(nomeLivro);
            ClienteDAO clienteDAO = new ClienteDAO();
            Cliente cliente = clienteDAO.pesquisarClientePorNome(nomeCliente);
            
            
            idCliente = cliente.getId_cliente();
            idLivro = livro.getId_livro();
            idReserva = reserva.getId_reserva();
            
            reserva.setId_reserva(idReserva);
            reserva.setId_funcionario(idFuncionario);
            reserva.setId_cliente(idCliente);
            reserva.setId_livro(idLivro);
            reserva.setStatus(status);
            reserva.setDatainicio(dataInicioReserva);
            reserva.setDatafim(dataFimReserva);
            
            reservaDAO.atualizarReserva(reserva);
            
            
        }   catch(SQLException erro){
                JOptionPane.showMessageDialog(null, "Atualizar reserva: " + erro);
                return;
        }   catch (NumberFormatException erro){
                JOptionPane.showMessageDialog(null, erro);
                return;
        }catch (ParseException erro) {
        JOptionPane.showMessageDialog(null, "Erro ao converter a data: " + erro.getMessage());
        return;
        }
            GerenciarReserva gerenciarReserva = new GerenciarReserva(funcionario);
            gerenciarReserva.setVisible(true);
            this.setVisible(false);
        
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
       atualizarValor();
       atualizarCategoria();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox3ActionPerformed


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AtualizarReserva(funcionario, reserva).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabel;
    private javax.swing.JLabel JLabel1;
    private javax.swing.JLabel JLabel2;
    private javax.swing.JLabel JLabel3;
    private javax.swing.JLabel JLabel4;
    private javax.swing.JButton btnCadastrar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JTextField campoCategoria;
    private javax.swing.JTextField campoDataInicio;
    private javax.swing.JTextField campoDatafim;
    private javax.swing.JTextField campoValor;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuItem jMenuItem1;
    // End of variables declaration//GEN-END:variables
}
