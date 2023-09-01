package com.fravel.star.domain.usuario;

import com.fravel.star.domain.Entidade;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table
public class Usuario extends Entidade {
    @Column(length = 100, nullable = false)
    private String nome;
    @Column(length = 11, nullable = false)
    private String cartao;

    public Usuario(){}

    public Usuario(String nome, String cartao) {
        this.nome = nome;
        this.cartao = cartao;
    }
}
