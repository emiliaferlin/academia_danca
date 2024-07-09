/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.cc.lpoo.academia_danca.test;

import br.edu.ifsul.cc.lpoo.academia_danca.dao.PersistenciaJPA;
import br.edu.ifsul.cc.lpoo.academia_danca.model.Contrato;
import br.edu.ifsul.cc.lpoo.academia_danca.model.FormaPagamento;
import br.edu.ifsul.cc.lpoo.academia_danca.model.Modalidade;
import br.edu.ifsul.cc.lpoo.academia_danca.model.Pacote;
import br.edu.ifsul.cc.lpoo.academia_danca.model.Pagamento;
import java.util.Calendar;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author Mili
 */
public class TestPersistenciaTeste {
    
    PersistenciaJPA jpa = new PersistenciaJPA();
    
    public TestPersistenciaTeste() {
    }
    
   
    @Before // o que fazer antes da persistencia
    public void setUp() {
        jpa.conexaoAberta();
    }
    
    @After
    public void tearDown() {
        jpa.fecharConexao();
    }
    
    
   // @Test
    public void testeModalidade() throws Exception {

        // criar meu obj Produto
        Modalidade m = new Modalidade();
        m.setDescricao("Dança Livre");

        Modalidade m2 = new Modalidade();
        m2.setDescricao("FitDance");

        Modalidade m3 = new Modalidade();
        m3.setDescricao("Gluteos");

        jpa.persist(m);
        jpa.persist(m2);
        jpa.persist(m3);
        
        Pacote pc = new Pacote();
        pc.setDescricao("testando pacotes");
        pc.setModalidade(m3);
        pc.setValor(540.94767);
        jpa.persist(pc);
        

        // buscar objeto persistido
        Modalidade persistidoModalidade = (Modalidade) jpa.find(Modalidade.class, m.getId());//ver se tem necessidade de fazer o mesmo pro m2 e m3

        // verificar se objeto persistido é igual ao criado
        Assert.assertEquals(m.getDescricao(), persistidoModalidade.getDescricao());

    }
    
    @Test
    public void testePagamento() throws Exception{
        Contrato c = new Contrato();
        c.setFormaPag(FormaPagamento.PIX);
        jpa.persist(c);
        Pagamento p1 = new Pagamento();
        p1.setDataPag(Calendar.getInstance());
        p1.setDataVenc(Calendar.getInstance());
        p1.setValor(200.463728);
        p1.setValorPagamento(240.985346);
        p1.setContratos(c);
        jpa.persist(p1);
    }
    
    
    
}
