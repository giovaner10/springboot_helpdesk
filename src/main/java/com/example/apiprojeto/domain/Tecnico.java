package com.example.apiprojeto.domain;

import com.example.apiprojeto.domain.enums.Perfil;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Tecnico extends Pessoa {
    private static final long serialVersionUID = 1L;


    @OneToMany(mappedBy = "tecnico")
    private List<Chamados> chamados = new ArrayList();


    public Tecnico(Integer id, String nome, String cpf, String email, String senha) {
        super(id, nome, cpf, email, senha);
        addPerfil(Perfil.TECNICO);
    }

    public Tecnico() {
        super();
        addPerfil(Perfil.TECNICO);
    }

    public List<Chamados> getChamados() {
        return chamados;
    }

    public void setChamados(List<Chamados> chamados) {
        this.chamados = chamados;
    }
}
