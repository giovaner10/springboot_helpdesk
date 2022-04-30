package com.example.apiprojeto.repository;

import com.example.apiprojeto.domain.Chamados;
import com.example.apiprojeto.domain.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChamadoRepository extends JpaRepository<Chamados, Integer> {
}
