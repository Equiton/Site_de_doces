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
@Table(name = "Clientes")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeCompleto;
    private String genero;
    private String enderecoCompleto;
    private String email;
    private String cep;
    private String cidade;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataNascimento;

    public Cliente() {
    }

    public Cliente(Long id, String nomeCompleto, String genero, String enderecoCompleto, String email, String cep,
            String cidade, Date dataNascimento) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.genero = genero;
        this.enderecoCompleto = enderecoCompleto;
        this.email = email;
        this.cep = cep;
        this.cidade = cidade;
        this.dataNascimento = dataNascimento;
    }

    public Cliente(Cliente cliente) {
        this.id = getId();
        this.nomeCompleto = getNomeCompleto();
        this.genero = getGenero();
        this.enderecoCompleto = getEnderecoCompleto();
        this.email = getEmail();
        this.cep = getCep();
        this.cidade = getCidade();
        this.dataNascimento = getDataNascimento();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEnderecoCompleto() {
        return enderecoCompleto;
    }

    public void setEnderecoCompleto(String enderecoCompleto) {
        this.enderecoCompleto = enderecoCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

}
