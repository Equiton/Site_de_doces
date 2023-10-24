package com.doces.doces.Model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="Dependentes")
public class Dependentes implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String nomeDependente;
    private String generoDepen;
    
    @Column(nullable=false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataNascimentoDepen;
    
    

    public Dependentes(){}

    public Dependentes(Long id, String nomeDependente, String generoDepen, Date dataNascimentoDepen){
        this.id = id;
        this.nomeDependente = nomeDependente;
        this.dataNascimentoDepen=dataNascimentoDepen;
        this.generoDepen=generoDepen;
    }

    public Dependentes(Dependentes dependetes){
        this.id = getId();
        this.nomeDependente = getNomeDependente();
        this.dataNascimentoDepen= getDataNascimentoDepen();
        this.generoDepen =getGeneroDepen();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeDependente() {
        return nomeDependente;
    }

    public void setNomeDependente(String nomeDependente) {
        this.nomeDependente = nomeDependente;
    }

    public Date getDataNascimentoDepen() {
        return dataNascimentoDepen;
    }

    public void setDataNascimentoDepen(Date dataNascimentoDepen) {
        this.dataNascimentoDepen = dataNascimentoDepen;
    }

    public String getGeneroDepen() {
        return generoDepen;
    }

    public void setGeneroDepen(String generoDepen) {
        this.generoDepen = generoDepen;
    }
    
}
