package com.example.apiprojeto.domain;


import com.example.apiprojeto.domain.enums.Perfil;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cliente extends Pessoa {
    private static final long serialVersionUID = 1L;


    @OneToMany(mappedBy = "cliente")
    private List<Chamados> chamados = new ArrayList();

    public Cliente(Integer id, String nome, String cpf, String email, String senha) {
        super(id, nome, cpf, email, senha);
        addPerfil(Perfil.CLIENTE);

    }

    public Cliente() {
        super();
        addPerfil(Perfil.CLIENTE);
    }

    public List<Chamados> getChamados() {
        return chamados;
    }

    public void setChamados(List<Chamados> chamados) {
        this.chamados = chamados;
    }
}
