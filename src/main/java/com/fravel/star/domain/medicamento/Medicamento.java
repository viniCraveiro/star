package com.fravel.star.domain.medicamento;

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
public class Medicamento extends Entidade {
    @Column(length = 100, nullable = false)
    private String nome;
    private String quantidade;
    @Column(length = 100, nullable = false)
    private String codigo;
    @Column(length = 100, nullable = false)
    private String tipo;
    private String validade;

    public Medicamento() {
    }

    public Medicamento(String nome, String quantidade, String codigo, String tipo) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.codigo = codigo;
        this.tipo = tipo;
    }
}
