/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.cc.lpoo.academia_danca.model;

import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import javax.persistence.Table;


/**
 *
 * @author Mili
 */
@Entity
@Table(name = "tb_folha_pagamento")
public class FolhaPagamento implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)//id sequencial
    private Integer id;
    
    @Column(name = "data_pagamento")
    private Calendar dataPag;
    
    @Column(name = "valor_receber")
    private double valorReceber;

    public FolhaPagamento() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    

    public Calendar getDataPag() {
        return dataPag;
    }

    public void setDataPag(Calendar dataPag) {
        this.dataPag = dataPag;
    }

    public double getValorReceber() {
        return valorReceber;
    }

    public void setValorReceber(double valorReceber) {
        this.valorReceber = valorReceber;
    }
    
    
    
}
