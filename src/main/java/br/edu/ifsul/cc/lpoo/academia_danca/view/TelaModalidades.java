/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.edu.ifsul.cc.lpoo.academia_danca.view;

import br.edu.ifsul.cc.lpoo.academia_danca.dao.CadastroModalidadeListener;
import br.edu.ifsul.cc.lpoo.academia_danca.dao.PersistenciaJPA;
import br.edu.ifsul.cc.lpoo.academia_danca.model.Modalidade;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.transaction.Transactional;

/**
 *
 * @author Mili
 */
public class TelaModalidades extends javax.swing.JFrame {

    /**
     * Creates new form TelaModalidades
     */
    PersistenciaJPA persistencia;
    public TelaModalidades() {
        initComponents();
        persistencia = new PersistenciaJPA();
        atualizarListaModalidades();
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstModalidades = new javax.swing.JList<>();
        btnNovo = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(lstModalidades);

        btnNovo.setText("Nova Modalidade");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnRemover.setText("Excluir Modalidade");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar Modalidade");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        jLabel1.setText("Listagem Modalidades");

        jLabel2.setText("Descrição:");

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(btnEditar)
                        .addGap(27, 27, 27)
                        .addComponent(btnRemover))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnRemover)
                    .addComponent(btnEditar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        Modalidade m = new Modalidade();
        m.setDescricao(JOptionPane.showInputDialog("Informe a descrição da modalidade:"));

        persistencia = new PersistenciaJPA();
        persistencia.conexaoAberta();
        persistencia.persist(m);
        persistencia.fecharConexao();
        JOptionPane.showMessageDialog(null, "Modalidade adicionada com sucesso!");
        atualizarListaModalidades();
        
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        Modalidade modalidadeSelecionada = lstModalidades.getSelectedValue();
        //persistencia.conexaoAberta();
        if (modalidadeSelecionada != null) {
            // Edição da Modalidade em Tela de Cadastro
            CadastroModalidade telaCadastro = new CadastroModalidade();

            telaCadastro.setModalidade(modalidadeSelecionada);
            telaCadastro.setListener(new CadastroModalidadeListener() {
                @Override
                public void onModalidadeAtualizada() {
                    atualizarListaModalidades();
                }
            });
            telaCadastro.setVisible(true);

           
        } else {
            JOptionPane.showMessageDialog(rootPane, "Selecione uma modalidade antes");
        }
        
        atualizarListaModalidades();
        
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        Modalidade modalidadeSelecionada = lstModalidades.getSelectedValue();
        if (modalidadeSelecionada != null) {
            int confirmacaoDel = JOptionPane.showConfirmDialog(rootPane,
                    "Tem certeza que deseja remover modalidade " + modalidadeSelecionada.getDescricao());
            if (confirmacaoDel == JOptionPane.YES_OPTION) {
                try {
                    persistencia = new PersistenciaJPA();
                    persistencia.conexaoAberta();
                    persistencia.remover(modalidadeSelecionada);
                    persistencia.fecharConexao();
                    atualizarListaModalidades();

                } catch (Exception e) {
                    System.err.println("Erro ao excluir modalidade: " + e.getMessage());
                } finally {
                    persistencia.fecharConexao();
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane,
                    "Nenhuma modalidade selecionada");
        }
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        String textoBusca = jTextField1.getText().trim();
        
        
        
        lstModalidades.clearSelection();
        persistencia.conexaoAberta();
        List<Modalidade> modal = persistencia.getModalidades(textoBusca);
        DefaultListModel<Modalidade> modalidades = new DefaultListModel<>();
        for (Modalidade m : modal) {
            modalidades.addElement(m);
        }
        
        lstModalidades.setModel(modalidades);
        persistencia.fecharConexao();
        
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        String textoBusca = jTextField1.getText().trim();
        
        
        
        lstModalidades.clearSelection();
        persistencia.conexaoAberta();
        List<Modalidade> modal = persistencia.getModalidades(textoBusca);
        DefaultListModel<Modalidade> modalidades = new DefaultListModel<>();
        for (Modalidade m : modal) {
            modalidades.addElement(m);
        }
        
        lstModalidades.setModel(modalidades);
        persistencia.fecharConexao();
    }//GEN-LAST:event_jTextField1KeyReleased


    private void atualizarListaModalidades() {
        lstModalidades.clearSelection();
        persistencia.conexaoAberta();
        List<Modalidade> modal = persistencia.getModalidades();
        DefaultListModel<Modalidade> modalidades = new DefaultListModel<>();
        for (Modalidade m : modal) {
            modalidades.addElement(m);
        }
        
        lstModalidades.setModel(modalidades);
        persistencia.fecharConexao();
    }
     

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaModalidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaModalidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaModalidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaModalidades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new TelaModalidades().setVisible(true);
            }
        });
    
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnRemover;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JList<Modalidade> lstModalidades;
    // End of variables declaration//GEN-END:variables
}
