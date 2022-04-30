package com.example.apiprojeto.service;

import com.example.apiprojeto.domain.Tecnico;
import com.example.apiprojeto.repository.TecnicoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Service
@AllArgsConstructor
public class TecnicosService {

    private final TecnicoRepository tecnicoRepository;

    public Tecnico findById( Integer id){
        return tecnicoRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("NAO ENCONTRADO"));
    }
}
