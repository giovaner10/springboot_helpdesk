package com.example.apiprojeto.controller;

import com.example.apiprojeto.domain.Tecnico;
import com.example.apiprojeto.service.TecnicosService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tecnico")
@AllArgsConstructor
public class TecnicosController {

    private TecnicosService tecnicosService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Tecnico> findById(@PathVariable Long id){


        return new ResponseEntity(tecnicosService.findById(id), HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<Tecnico>> findAll(){


        return new ResponseEntity<>(tecnicosService.findAll(), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Tecnico> save(@RequestBody @Valid Tecnico tecnico){


        return new ResponseEntity(tecnicosService.save(tecnico), HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Tecnico> update(@RequestBody @Valid Tecnico tecnico, @PathVariable Long id){
        tecnico.setId(id);

        return new ResponseEntity(tecnicosService.update(tecnico), HttpStatus.CREATED);

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Tecnico> delete( @PathVariable Long id){

        tecnicosService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }
}
