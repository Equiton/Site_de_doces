package com.doces.doces.Repository;

import com.doces.doces.Model.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    
}
