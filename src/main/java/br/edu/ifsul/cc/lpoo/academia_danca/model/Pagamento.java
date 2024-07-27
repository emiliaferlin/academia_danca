/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.cc.lpoo.academia_danca.model;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Mili
 */


@Entity
@Table(name = "tb_pagamento")
public class Pagamento implements Serializable{
    
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   private Integer id;
   
   @Column(name = "data_vencimento", nullable = false)
   @Temporal(TemporalType.TIMESTAMP)
   private Calendar dataVenc;
   
   @Column(name = "valor", columnDefinition = "decimal(12,2)")
   private double valor;
   
   @Column(name = "valor_pagamento", columnDefinition = "decimal(12,2)")
   private double valorPagamento;
   
   @Column(name = "data_pagamento")
   @Temporal(TemporalType.TIMESTAMP)
   private Calendar dataPag;
   
   @ManyToOne
   @JoinColumn(name = "Contrato", referencedColumnName = "id", nullable = false)
   private Contrato contrato;
   
   public Contrato getContratos() {
        return contrato;
    }

    public void setContratos(Contrato contrato) {
        this.contrato = contrato;
    }

    public Pagamento() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

}
