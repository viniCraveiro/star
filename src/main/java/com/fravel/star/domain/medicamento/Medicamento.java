package com.fravel.star.domain.medicamento;

import com.fravel.star.domain.Entidade;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table
public class Medicamento extends Entidade {
    @Column(length = 100, nullable = false)
    private String nome;
    @Column(length = 100, nullable = false)
    private String codigo;
    @Column(length = 100, nullable = false)
    private String tipo;
    private BigDecimal mg;

    public Medicamento() {
    }

    public Medicamento(String nome, String codigo, String tipo, BigDecimal mg) {
        this.nome = nome;
        this.codigo = codigo;
        this.tipo = tipo;
        this.mg = mg;
    }
}
