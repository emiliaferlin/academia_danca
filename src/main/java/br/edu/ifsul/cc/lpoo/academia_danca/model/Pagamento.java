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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Mili
 */


@Entity
public class Pagamento {
    
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   private int id;
   
   @Column(name = "data_vencimento", nullable = false)
   private Calendar dataVenc;
   
   @Column(name = "valor", precision = 10, scale = 2)
   private double valor;
   
   @Column(name = "valor_pagamento", precision = 10, scale = 2)
   private double valorPagamento;
   
   @Column(name = "data_pagamento")
   private Calendar dataPag;
   
   @ManyToOne
   @JoinColumn(name = "Contrato", referencedColumnName = "id", nullable = false)
   private Contrato contrato;

    public Pagamento() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Calendar getDataVenc() {
        return dataVenc;
    }

    public void setDataVenc(Calendar dataVenc) {
        this.dataVenc = dataVenc;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getValorPagamento() {
        return valorPagamento;
    }

    public void setValorPagamento(double valorPagamento) {
        this.valorPagamento = valorPagamento;
    }

    public Calendar getDataPag() {
        return dataPag;
    }

    public void setDataPag(Calendar dataPag) {
        this.dataPag = dataPag;
    }

    private static class Contrato {

        public Contrato() {
        }
    }
   
   
   
   
    
    
}
