package com.example.apiprojeto.domain.enums;

import java.util.Optional;

public enum Prioridade {

    BAIXA(0, "BAIXA"), MEDIA(1, "MEDIA"), ALTA(2, "ALTA");


    private Integer codigo;
    private String descricao;

    Prioridade(Integer codigo, String role) {
        this.codigo = codigo;
        this.descricao = role;

    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Prioridade toEnum(Integer cod){
       Prioridade perfil = null;
        if(cod == null){
            perfil = null;
        }else {
            for(Prioridade pessoa : Prioridade.values()){
                if(cod.equals(pessoa.getCodigo())){
                    perfil = pessoa;
                    break;
                }
            }
        }
        return Optional.ofNullable(perfil).orElseThrow(() -> new IllegalArgumentException("NAO ENCONTRADO"));
    }
}
