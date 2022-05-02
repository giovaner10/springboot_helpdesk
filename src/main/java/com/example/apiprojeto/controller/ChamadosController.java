package com.example.apiprojeto.controller;

import com.example.apiprojeto.domain.Chamados;
import com.example.apiprojeto.service.ChamadosService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/chamados")
@AllArgsConstructor
public class ChamadosController {

    private ChamadosService chamadosService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Chamados> findById(@PathVariable Long id){


        return new ResponseEntity(chamadosService.findById(id), HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<Chamados>> findAll(){


        return new ResponseEntity<>(chamadosService.findAll(), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Chamados> save(@RequestBody @Valid Chamados chamados){


        return new ResponseEntity(chamadosService.save(chamados), HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Chamados> update(@RequestBody @Valid Chamados chamados, @PathVariable Long id){
        chamados.setId(id);

        return new ResponseEntity(chamadosService.update(chamados), HttpStatus.CREATED);

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Chamados> delete( @PathVariable Long id){

        chamadosService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }
}
