/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.edu.ifsul.cc.lpoo.academia_danca.view;

import br.edu.ifsul.cc.lpoo.academia_danca.dao.PersistenciaJPA;
import br.edu.ifsul.cc.lpoo.academia_danca.model.Modalidade;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.NoResultException;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Mili
 */
public class TelaModalidades extends javax.swing.JFrame {

    /**
     * Creates new form TelaModalidades
     */
    private PersistenciaJPA persistencia;
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

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lstModalidades.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNovo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(btnEditar)
                        .addGap(27, 27, 27)
                        .addComponent(btnRemover)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
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
       String descricao = JOptionPane.showInputDialog(null, "Digite a descrição da nova modalidade:", "Nova Modalidade", JOptionPane.PLAIN_MESSAGE);
        if (descricao != null && !descricao.trim().isEmpty()) {
            Modalidade novaModalidade = new Modalidade();
            novaModalidade.setDescricao(descricao);

            try {
                persistencia.conexaoAberta();
                persistencia.persist(novaModalidade);
                persistencia.fecharConexao();
                JOptionPane.showMessageDialog(null, "Modalidade adicionada com sucesso!");
                atualizarListaModalidades(); // Atualiza a lista após adicionar nova modalidade
            } catch (Exception ex) {
                Logger.getLogger(TelaModalidades.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro ao adicionar modalidade.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Descrição não pode ser vazia.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // Solicita ao usuário a descrição da modalidade a ser editada
        String descricao = JOptionPane.showInputDialog(null, "Digite a descrição da modalidade que deseja editar:", "Editar Modalidade", JOptionPane.PLAIN_MESSAGE);

        if (descricao != null && !descricao.trim().isEmpty()) {
            try {
                // Abre a conexão com o banco de dados
                persistencia.conexaoAberta();

                // Procura a modalidade pelo campo descrição
                Modalidade modalidadeParaEditar = persistencia.buscarPorDescricao(descricao);

                // Verifica se a modalidade foi encontrada
                if (modalidadeParaEditar != null) {
                    // Solicita ao usuário a nova descrição
                    String novaDescricao = JOptionPane.showInputDialog(null, "Digite a nova descrição para a modalidade:", modalidadeParaEditar.getDescricao());

                    if (novaDescricao != null && !novaDescricao.trim().isEmpty()) {
                        modalidadeParaEditar.setDescricao(novaDescricao);

                        // Atualiza a modalidade no banco de dados
                        persistencia.persist(modalidadeParaEditar);
                        JOptionPane.showMessageDialog(null, "Modalidade editada com sucesso!");
                        atualizarListaModalidades(); // Atualiza a lista após editar a modalidade
                    } else {
                        JOptionPane.showMessageDialog(null, "A nova descrição não pode ser vazia.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Modalidade não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
                }

                // Fecha a conexão com o banco de dados
                persistencia.fecharConexao();
            } catch (NoResultException e) {
                JOptionPane.showMessageDialog(null, "Modalidade não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                Logger.getLogger(TelaModalidades.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro ao editar modalidade.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Descrição não pode ser vazia.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
         // Solicita ao usuário a descrição da modalidade a ser excluída
    String descricao = JOptionPane.showInputDialog(null, "Digite a descrição da modalidade que deseja excluir:", "Excluir Modalidade", JOptionPane.PLAIN_MESSAGE);
    
    if (descricao != null && !descricao.trim().isEmpty()) {
        try {
            // Abre a conexão com o banco de dados
            persistencia.conexaoAberta();

            // Procura a modalidade pelo campo descrição
            Modalidade modalidadeParaExcluir = persistencia.buscarPorDescricao(descricao);

            // Verifica se a modalidade foi encontrada
            if (modalidadeParaExcluir != null) {
                // Remove a modalidade do banco de dados
                persistencia.remover(modalidadeParaExcluir);
                JOptionPane.showMessageDialog(null, "Modalidade excluída com sucesso!");
                atualizarListaModalidades(); // Atualiza a lista após excluir a modalidade
            } else {
                JOptionPane.showMessageDialog(null, "Modalidade não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
            }

            // Fecha a conexão com o banco de dados
            persistencia.fecharConexao();
        } catch (NoResultException e) {
            JOptionPane.showMessageDialog(null, "Modalidade não encontrada.", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            Logger.getLogger(TelaModalidades.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao excluir modalidade.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(null, "Descrição não pode ser vazia.", "Erro", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void atualizarListaModalidades() {
        try {
            List<Modalidade> modalidades = persistencia.getModalidades();
            DefaultListModel<String> model = new DefaultListModel<>();
            for (Modalidade modalidade : modalidades) {
                model.addElement(modalidade.getDescricao());
            }
            lstModalidades.setModel(model);
        } catch (Exception ex) {
            Logger.getLogger(TelaModalidades.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Erro ao carregar modalidades.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> lstModalidades;
    // End of variables declaration//GEN-END:variables
}
