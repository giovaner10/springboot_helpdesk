package com.example.apiprojeto.repository;

import com.example.apiprojeto.domain.Chamados;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChamadoRepository extends JpaRepository<Chamados, Integer> {
}
