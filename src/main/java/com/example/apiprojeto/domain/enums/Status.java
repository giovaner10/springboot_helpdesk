package com.example.apiprojeto.domain.enums;

import java.util.Optional;

public enum Status {

    ABERTO(0, "ABERTO"), ANDAMENTO(1, "ANDAMENTO"), ENCERRADO(2, "ENCERRADO");


    private Integer codigo;
    private String descricao;

    Status(Integer codigo, String role) {
        this.codigo = codigo;
        this.descricao = role;

    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Status toEnum(Integer cod){
       Status perfil = null;
        if(cod == null){
            perfil = null;
        }else {
            for(Status pessoa : Status.values()){
                if(cod.equals(pessoa.getCodigo())){
                    perfil = pessoa;
                    break;
                }
            }
        }
        return Optional.ofNullable(perfil).orElseThrow(() -> new IllegalArgumentException("NAO ENCONTRADO"));
    }
}
