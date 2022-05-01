package com.example.apiprojeto.bean;

import com.example.apiprojeto.domain.Tecnico;
import com.example.apiprojeto.domain.dto.TecnicoDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class TecnicoAssembler {


    private ModelMapper modelMapper;

    public TecnicoDTO tecnicoDTO(Optional<Tecnico> tecnico){
      return modelMapper.map(tecnico, TecnicoDTO.class);
    }

    public Tecnico tecnico(TecnicoDTO tecnico){
        return modelMapper.map(tecnico, Tecnico.class);
    }








}
