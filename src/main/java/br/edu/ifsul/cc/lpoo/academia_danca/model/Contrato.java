/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.cc.lpoo.academia_danca.model;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;

/**
 *
 * @author Mili
 */

@Entity
public class Contrato implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name = "data_inicio" , nullable = false)
    private Calendar dataInicio;
    
    @Column(name = "valor_desconto", precision = 10, scale = 2)
    private double valorDesc;
    
    @Column(name = "forma_pagamento", nullable = false)
    @Enumerated(EnumType.STRING)
    private FormaPagamento formaPag;
    
    @OneToMany(mappedBy = "contratos", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.LAZY)
    private List<ItensContrato> itensContrato= new ArrayList();
   
   private void adicionaItens(ItensContrato obj){
        itensContrato.add(obj);
   }
    private void removeItens(ItensContrato obj){
        itensContrato.remove(obj);
   }
    
    public FormaPagamento getFormaPag() {
        return formaPag;
    }

    public void setFormaPag(FormaPagamento formaPag) {
        this.formaPag = formaPag;
    }
   
    public Contrato() {
       //atualiza automaticamente
       dataInicio = Calendar.getInstance();
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Calendar dataInicio) {
        this.dataInicio = dataInicio;
    }

    public double getValorDesc() {
        return valorDesc;
    }

    public void setValorDesc(double valorDesc) {
        this.valorDesc = valorDesc;
    }
    
    
    
}
