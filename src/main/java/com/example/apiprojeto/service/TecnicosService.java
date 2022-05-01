package com.example.apiprojeto.service;

import com.example.apiprojeto.bean.TecnicoAssembler;
import com.example.apiprojeto.domain.Tecnico;
import com.example.apiprojeto.domain.enums.Perfil;
import com.example.apiprojeto.exceptions.ObjectNotFoundException;
import com.example.apiprojeto.repository.TecnicoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TecnicosService {

    private final TecnicoRepository tecnicoRepository;
    private final TecnicoAssembler tecnicoAssembler;

    public Optional<Tecnico> findById(Integer id) {

        return Optional.ofNullable(tecnicoRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Tecnico nao registrado")));

    }

    public List<Tecnico> findAll(){

        return tecnicoRepository.findAll();
    }

    public Tecnico save(Tecnico tecnico){
        tecnico.setPerfis(Perfil.CLIENTE);
        tecnico.setPerfis(Perfil.TECNICO);
        return tecnicoRepository.save(tecnico);
    }
}
