package com.example.apiprojeto.repository;

import com.example.apiprojeto.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository  extends JpaRepository<Pessoa, Integer> {
}
