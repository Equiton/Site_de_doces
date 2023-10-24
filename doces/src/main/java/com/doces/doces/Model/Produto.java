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
@Table(name = "Produtos")
public class Produto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeDoProduto;
    private String marca;
    private float altura;
    private float largura;
    private float profundidade;
    private float volume;

    private float peso;
    private float precoDeCompra;
    private float precoDeVenda;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataDeCadastro;

    public Produto() {
    }

    public Produto(Long id, String nomeDoProduto, String marca, float altura, float largura, float profundidade,
            float volume, float peso, float precoDeCompra, float precoDeVenda, Date dataDeCadastro) {
        this.id = id;
        this.nomeDoProduto = nomeDoProduto;
        this.marca = marca;
        this.altura = altura;
        this.largura = largura;
        this.profundidade = profundidade;
        this.volume = volume;
        this.peso = peso;
        this.precoDeCompra = precoDeCompra;
        this.precoDeVenda = precoDeVenda;
        this.dataDeCadastro = dataDeCadastro;
    }

    public Produto(Produto produto) {
        this.id = getId();
        this.nomeDoProduto = getNomeDoProduto();
        this.marca = getMarca();
        this.altura = getAltura();
        this.largura = getLargura();
        this.profundidade = getProfundidade();
        this.volume = getVolume();
        this.peso = getPeso();
        this.precoDeCompra = getPrecoDeCompra();
        this.precoDeVenda = getPrecoDeVenda();
        this.dataDeCadastro = getDataDeCadastro();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeDoProduto() {
        return nomeDoProduto;
    }

    public void setNomeDoProduto(String nomeDoProduto) {
        this.nomeDoProduto = nomeDoProduto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getLargura() {
        return largura;
    }

    public void setLargura(float largura) {
        this.largura = largura;
    }

    public float getProfundidade() {
        return profundidade;
    }

    public void setProfundidade(float profundidade) {
        this.profundidade = profundidade;
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getPrecoDeCompra() {
        return precoDeCompra;
    }

    public void setPrecoDeCompra(float precoDeCompra) {
        this.precoDeCompra = precoDeCompra;
    }

    public float getPrecoDeVenda() {
        return precoDeVenda;
    }

    public void setPrecoDeVenda(float precoDeVenda) {
        this.precoDeVenda = precoDeVenda;
    }

    public Date getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(Date dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

}
