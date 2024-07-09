/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.cc.lpoo.academia_danca.model;

import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;


/**
 *
 * @author Mili
 */

@Entity
public class Alunos extends Pessoas implements Serializable{
    
    @Column(name = "data_inicio")
    @Temporal(TemporalType.DATE)//dia, mes e ano
    private Calendar dataInicio;
    
    @Column(name = "data_pagamento_dia")
    private int dataPag;

    public Alunos() {
    }

    public Calendar getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Calendar dataInicio) {
        this.dataInicio = dataInicio;
    }

    public int getDataPag() {
        return dataPag;
    }

    public void setDataPag(int dataPag) {
        this.dataPag = dataPag;
    }
    
    
    
    
}
