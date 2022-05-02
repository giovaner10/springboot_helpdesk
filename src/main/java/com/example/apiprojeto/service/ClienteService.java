package com.example.apiprojeto.service;

import com.example.apiprojeto.domain.Cliente;
import com.example.apiprojeto.domain.enums.Perfil;
import com.example.apiprojeto.exceptions.ObjectNotFoundException;
import com.example.apiprojeto.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    public Optional<Cliente> findById(Long id) {

        return Optional.ofNullable(clienteRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Cliente nao registrado")));

    }

    public List<Cliente> findAll() {

        return clienteRepository.findAll();
    }

    public Cliente save(Cliente cliente) {
        cliente.setPerfis(Perfil.CLIENTE);

        String senha = cliente.getSenha();
        String encode = bCryptPasswordEncoder.encode(senha);
        cliente.setSenha(encode);

        return clienteRepository.save(cliente);
    }

    public Cliente update(Cliente Cliente) {
        findById(Cliente.getId());

        return save(Cliente);
    }

    public void delete(Long id) {
        findById(id);

        clienteRepository.deleteById(id);
    }
}
