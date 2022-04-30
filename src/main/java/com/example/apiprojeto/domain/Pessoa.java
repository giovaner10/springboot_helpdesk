package com.example.apiprojeto.domain;

import com.example.apiprojeto.domain.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.web.JsonPath;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public abstract class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    protected Integer id;
    protected String nome;
    protected String cpf;
    protected String email;
    protected String senha;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "perfis")
    protected Set<Integer> perfis = new HashSet<>();
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate dataCriacao = LocalDate.now();

    public Pessoa() {
        addPerfil(Perfil.CLIENTE);
    }

    public Pessoa(Integer id, String nome, String cpf, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
          addPerfil(Perfil.CLIENTE);

    }

    public void addPerfil(Perfil perfil){
        this.perfis.add(perfil.getCodigo());
    }

    public Set<Perfil> gettPerfil(){
        return this.perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
    }


}
