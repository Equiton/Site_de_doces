package com.doces.doces.Repository;

import com.doces.doces.Model.Produto;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProdutosRepository extends JpaRepository <Produto, Long>{
    @Query("SELECT prod FROM Produto prod WHERE prod.nomeDoProduto LIKE %:nomeE% OR prod.marca LIKE %:nomeE% ")
    List<Produto> findByNome(@Param("nomeE") String nome);

    @Query("SELECT prod FROM Produto prod WHERE prod.peso = :nomeE OR prod.altura = :nomeE OR prod.largura = :nomeE OR prod.profundidade = :nomeE OR prod.volume = :nomeE OR prod.precoDeCompra = :nomeE OR prod.precoDeVenda = :nomeE")
    List<Produto> findByPeso(@Param("nomeE") Float nome);

}
