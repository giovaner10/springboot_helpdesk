package com.example.apiprojeto.repository;

import com.example.apiprojeto.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
