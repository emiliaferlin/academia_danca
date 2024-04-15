/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.cc.lpoo.academia_danca.test;

import br.edu.ifsul.cc.lpoo.academia_danca.dao.PersistenciaJPA;
import br.edu.ifsul.cc.lpoo.academia_danca.model.Modalidade;
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
    
    
    //@Test
    public void testeModalidade() throws Exception{
         Modalidade m = new Modalidade();
         m.setDescricao("Danca Livre");
         
         Modalidade m2 = new Modalidade();
         m2.setDescricao("FitDance");
         
         Modalidade m3 = new Modalidade();
         m3.setDescricao("Gluteos");
         // persistir objeto 
         jpa.persist(m);
         jpa.persist(m2);
         jpa.persist(m3);
        
        //persistir objeto
        Modalidade persistindoProd = (Modalidade)jpa.find(Modalidade.class, m.getId());
         
        // verificar se objeto persistido é igual ao criado
        Assert.assertEquals(m.getDescricao(),persistindoProd.getDescricao());
    }
    
    @Test
    public void testePagamento() throws Exception{
         Pagamento p = new Pagamento();
         Calendar c = Calendar.getInstance();
         c.set(Calendar.YEAR, 2024);
         c.set(Calendar.MONTH, Calendar.APRIL); // Janeiro é 0, Fevereiro é 1, ..., Dezembro é 11
         c.set(Calendar.DAY_OF_MONTH, 10);
         p.setDataPag(c);
         p.setDataVenc(c);
         p.setValor(140.00);
         p.setValorPagamento(140.00);
         
         // persistir objeto 
         jpa.persist(p);
        
        //persistir objeto
        Pagamento persistindoProd = (Pagamento)jpa.find(Pagamento.class, p.getId());
         
        // verificar se objeto persistido é igual ao criado
        Assert.assertEquals(p.getDataPag(),persistindoProd.getDataPag());
    }
    
}
