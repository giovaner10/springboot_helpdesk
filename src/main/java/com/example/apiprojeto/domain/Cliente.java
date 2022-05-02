package com.example.apiprojeto.domain;

import com.example.apiprojeto.domain.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @CPF
    private String cpf;
    @Email
    private String email;
    private String senha;
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Integer> perfis = new HashSet<>();
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataCriacao = LocalDate.now();

    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private List<Chamados> chamados = new ArrayList<>();

    public Cliente() {

    }


    public void setPerfis(Perfil perfil){
        this.perfis.add(perfil.getCodigo());
    }

    public Set<Perfil> getPerfis(){
        return this.perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }



    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }
}
