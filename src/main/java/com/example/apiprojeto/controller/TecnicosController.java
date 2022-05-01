package com.example.apiprojeto.controller;

import com.example.apiprojeto.domain.Tecnico;
import com.example.apiprojeto.domain.dto.TecnicoDTO;
import com.example.apiprojeto.service.TecnicosService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tecnicos")
@AllArgsConstructor
public class TecnicosController {

    private TecnicosService tecnicosService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Tecnico> findById(@PathVariable Integer id){


        return new ResponseEntity(tecnicosService.findById(id), HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<Tecnico>> findAll(){


        return new ResponseEntity<>(tecnicosService.findAll(), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Tecnico> save(@RequestBody Tecnico tecnico){


        return new ResponseEntity(tecnicosService.save(tecnico), HttpStatus.CREATED);

    }
}
