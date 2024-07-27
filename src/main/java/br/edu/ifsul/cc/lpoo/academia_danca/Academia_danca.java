/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.edu.ifsul.cc.lpoo.academia_danca;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Mili
 */
public class Academia_danca {

    public static void main(String[] args) {
        JFrame janela = new JFrame();
        janela.setSize(300, 400);//definir o tamannho da janela, ela não é visivel por padrao

        janela.setTitle("Bem Vindo(a) a academia de dança"); //titulo a cima 

        //precisa ser definido um gerenciador de leyout para organizar os componentes na tela
        janela.setLayout(new FlowLayout());
        JLabel lbNome= new JLabel("Nome: ");//cria o elemento e ja adiciona o nome no construtor


        JTextField txtNome= new JTextField(20);//cria um campo de texto pra poder escrever, int colun ja define o tamanho da caixa de texto
        JButton btEnviar= new JButton("Enviar");

        //adicionar na janela na ordem que quer que eles apareçam 
        janela.add(lbNome); //adiciona o componente a tela
        janela.add(txtNome);
        janela.add(btEnviar);

        //evento de clique do botão
        btEnviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  JOptionPane.showMessageDialog(janela, "Bem vindo(a): " + txtNome.getText());//vincula a janela e coloca o resultado do nome 
            }
        });




        janela.setVisible(true);//manda mostrar a janela
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//diz pra quando apertar no x ela fechar por completo
    }
}
