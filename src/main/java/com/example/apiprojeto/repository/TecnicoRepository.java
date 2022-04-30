package com.example.apiprojeto.repository;

import com.example.apiprojeto.domain.Pessoa;
import com.example.apiprojeto.domain.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {
}
