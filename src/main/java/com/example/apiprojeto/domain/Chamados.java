package com.example.apiprojeto.domain;

import com.example.apiprojeto.domain.enums.Prioridade;
import com.example.apiprojeto.domain.enums.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Optional;

@Entity
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Chamados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
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
    @JsonProperty("cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "tecnico_id")
    @JsonProperty("tecnico")
    private Tecnico tecnico;

    public void setId(Long id) {
        this.id = id;
    }


}
