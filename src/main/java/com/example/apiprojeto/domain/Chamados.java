package com.example.apiprojeto.domain;

import com.example.apiprojeto.domain.enums.Prioridade;
import com.example.apiprojeto.domain.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Chamados implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataAbertura = LocalDate.now();
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataFechamento;
    private Prioridade prioridade;
    private Status status;
    private String titulo;
    private String observacoes;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @JsonIgnore
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "tecnico_id")
    @JsonIgnore
    private Tecnico tecnico;

    public Chamados(Integer id, Prioridade prioridade, Status status, String titulo, String observacoes) {
        this.id = id;
        this.prioridade = prioridade;
        this.status = status;
        this.titulo = titulo;
        this.observacoes = observacoes;
    }
}