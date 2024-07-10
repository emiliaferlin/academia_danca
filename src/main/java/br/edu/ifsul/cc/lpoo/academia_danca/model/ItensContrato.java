/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.cc.lpoo.academia_danca.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;




/**
 *
 * @author Mili
 */

@Entity
public class ItensContrato implements Serializable{
    
     //tem como chave estrangeira contrato e pacote, ver como fazer 
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)//id sequencial
    private Integer idContrato;
    
    
    @ManyToOne
    @JoinColumn(name = "contratos_id")
    private Contrato contratos;
    
    @ManyToOne
    @JoinColumn(name = "pacotes_id")
    private Pacote pacotes;

    public ItensContrato() {
    }
    

    public Contrato getContratos() {
        return contratos;
    }

    public void setContratos(Contrato contratos) {
        this.contratos = contratos;
    }

    public Pacote getPacotes() {
        return pacotes;
    }

    public void setPacotes(Pacote pacotes) {
        this.pacotes = pacotes;
    }
    

    
}
