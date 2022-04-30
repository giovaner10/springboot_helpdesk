package com.example.apiprojeto.controller;

import com.example.apiprojeto.domain.Tecnico;
import com.example.apiprojeto.service.TecnicosService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tecnicos")
@AllArgsConstructor
public class TecnicosController {

    private TecnicosService tecnicosService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Tecnico> findById(@PathVariable Integer id){
        return new ResponseEntity<>(tecnicosService.findById(id), HttpStatus.OK);

    }
}
