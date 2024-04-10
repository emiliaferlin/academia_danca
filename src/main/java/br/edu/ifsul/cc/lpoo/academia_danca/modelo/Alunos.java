/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.cc.lpoo.academia_danca.modelo;

import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author Mili
 */

@Entity
public class Alunos extends Pessoas{
    
    @Column(name = "data_inicio")
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
