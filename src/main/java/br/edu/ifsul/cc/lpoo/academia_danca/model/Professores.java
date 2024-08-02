/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.cc.lpoo.academia_danca.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Mili
 */

@Entity
@Table(name = "tb_professores")
@NamedQueries({@NamedQuery(name="Professores.orderbyid", query="select m from Professores m order by m.id asc")})
public class Professores extends Pessoas implements Serializable{
    
    @Column(name = "data_admissao")
    @Temporal(TemporalType.DATE)//dia, mes e ano
    private Calendar dataAdmissao;
    
    @OneToMany
    private List<FolhaPagamento> folhaPag = new ArrayList();
    
    @OneToMany
    private List<Modalidade> modalidade = new ArrayList();

    public Professores() {
        
    }

    public Calendar getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Calendar dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }
    
    
    
}
