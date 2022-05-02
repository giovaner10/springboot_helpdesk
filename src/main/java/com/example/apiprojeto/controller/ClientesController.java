package com.example.apiprojeto.controller;

import com.example.apiprojeto.domain.Cliente;
import com.example.apiprojeto.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/clientes")
@AllArgsConstructor
public class ClientesController {

    private ClienteService clienteService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Long id){


        return new ResponseEntity(clienteService.findById(id), HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<Cliente>> findAll(){


        return new ResponseEntity<>(clienteService.findAll(), HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody @Valid Cliente cliente){


        return new ResponseEntity(clienteService.save(cliente), HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@RequestBody @Valid Cliente cliente, @PathVariable Long id){
        cliente.setId(id);

        return new ResponseEntity(clienteService.update(cliente), HttpStatus.CREATED);

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Cliente> delete( @PathVariable Long id){

        clienteService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }
}
