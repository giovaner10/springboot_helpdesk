package com.example.apiprojeto.service;

import com.example.apiprojeto.domain.Chamados;
import com.example.apiprojeto.domain.Cliente;
import com.example.apiprojeto.domain.Tecnico;
import com.example.apiprojeto.domain.enums.Status;
import com.example.apiprojeto.exceptions.ObjectNotFoundException;
import com.example.apiprojeto.repository.ChamadoRepository;
import com.example.apiprojeto.repository.TecnicoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ChamadosService {

    private final ChamadoRepository chamadoRepository;
    private final ClienteService clienteService;
    private final TecnicosService tecnicosService;


    public Chamados findById(Long id) {

        return chamadoRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Chamado nao registrado"));


    }

    public List<Chamados> findAll() {

        return chamadoRepository.findAll();
    }

    public Chamados save(Chamados chamados) {
        tecnicosService.findById(chamados.getTecnico().getId());
        clienteService.findById(chamados.getCliente().getId());

        chamados.setStatus(Status.ABERTO);
        return chamadoRepository.save(chamados);
    }

    public Chamados update(Chamados chamados) {
        findById(chamados.getId());
        tecnicosService.findById(chamados.getTecnico().getId());
        clienteService.findById(chamados.getCliente().getId());

        return save(chamados);
    }

    public void delete(Long id) {
        findById(id);

        chamadoRepository.deleteById(id);
    }
}
