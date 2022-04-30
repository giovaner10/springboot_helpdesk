package com.example.apiprojeto.domain.enums;

import java.util.Optional;

public enum Perfil {

    ADMIN(0, "ROLE_ADMIN"), CLIENTE(1, "ROLE_CLIENTE"), TECNICO(2, "ROLE_TECNICO");


    private Integer codigo;
    private String descricao;

    Perfil(Integer codigo, String role) {
        this.codigo = codigo;
        this.descricao = role;

    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static Perfil toEnum(Integer cod){
       Perfil perfil = null;
        if(cod == null){
            perfil = null;
        }else {
            for(Perfil pessoa : Perfil.values()){
                if(cod.equals(pessoa.getCodigo())){
                    perfil = pessoa;
                    break;
                }
            }
        }
        return Optional.ofNullable(perfil).orElseThrow(() -> new IllegalArgumentException("NAO ENCONTRADO"));
    }
}
