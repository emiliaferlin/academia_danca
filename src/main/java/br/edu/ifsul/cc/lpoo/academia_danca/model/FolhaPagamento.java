/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.cc.lpoo.academia_danca.model;

import java.util.Calendar;
import javax.persistence.Entity;

/**
 *
 * @author Mili
 */
@Entity
public class FolhaPagamento {
    
    private Calendar dataPag;
    private double valorReceber;

    public FolhaPagamento() {
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
