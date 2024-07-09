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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 *
 * @author Mili
 */

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)//herança
public abstract class Pessoas implements Serializable{
   
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    
    @Column(name = "nome_pessoa")
    private String nome;
     
    @Column(name = "telefone")
    private String fone;
      
    @Column(name = "data_aniversario")
    private Calendar dataAniver;
       
    @Column(name = "email")
    private String email;
        
    @Column(name = "endereco")
    private String endereco;

    public Pessoas() {
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public Calendar getDataAniver() {
        return dataAniver;
    }

    public void setDataAniver(Calendar dataAniver) {
        this.dataAniver = dataAniver;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    
    
    
}
