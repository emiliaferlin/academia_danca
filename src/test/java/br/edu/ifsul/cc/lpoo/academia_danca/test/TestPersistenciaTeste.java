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
    
    
    @Test
    public void testeModalidade() throws Exception{
        Modalidade m = new Modalidade();
        m.setDescricao("Fit Dance");
        
        
        //persistir objeto
        jpa.persist(m);
        Modalidade persistindoProd = (Modalidade)jpa.find(Modalidade.class, m.getId());
        
        Assert.assertEquals(m.getDescricao(), persistindoProd);
    }
    
}
