/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.cc.lpoo.academia_danca.test;

import br.edu.ifsul.cc.lpoo.academia_danca.dao.PersistenciaJPA;
import br.edu.ifsul.cc.lpoo.academia_danca.modelo.Modalidade;


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
        
        //Assert.assertEquals(m.getDescricao(), persistindoProd);
        
        // Modalidades persistidoModalidade = (Modalidades)jpa.find(Modalidades.class, m.getId());//ver se tem necessidade de fazer o mesmo pro m2 e m3
         
        // verificar se objeto persistido é igual ao criado
        Assert.assertEquals(m.getDescricao(),persistindoProd.getDescricao());
    }
    
}
