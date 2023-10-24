package com.doces.doces.Model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Pedidos")
public class Pedidos implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String formaPagamento;

    @OneToOne
    private Produto comercio;

    public Produto getComercio() {
        return this.comercio;
    }

    public void setComercio(Produto comercio) {
        this.comercio = comercio;
    }

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataDaVenda;

    private int quantidadeProdutos;


    public Pedidos(){}

    public Pedidos(Long id, String formaPagamento, Date dataDaVenda, int quantidadeProdutos){
        this.id=id;
        this.formaPagamento=formaPagamento;
        this.dataDaVenda=dataDaVenda;
        this.quantidadeProdutos=quantidadeProdutos;
    }

    public Pedidos(Pedidos pedidos){
        this.id=getId();
        this.formaPagamento=getFormaPagamento();
        this.dataDaVenda=getDataDaVenda();
        this.quantidadeProdutos=getQuantidadeProdutos();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Date getDataDaVenda() {
        return dataDaVenda;
    }

    public void setDataDaVenda(Date dataDaVenda) {
        this.dataDaVenda = dataDaVenda;
    }

    public int getQuantidadeProdutos() {
        return quantidadeProdutos;
    }

    public void setQuantidadeProdutos(int quantidadeProdutos) {
        this.quantidadeProdutos = quantidadeProdutos;
    }




}
