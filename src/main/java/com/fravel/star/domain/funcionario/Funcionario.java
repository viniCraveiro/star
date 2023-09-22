package com.fravel.star.domain.funcionario;

import com.fravel.star.domain.Entidade;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Funcionario extends Entidade {
    private String nome;
    private String cargo;
    private String observacao;
    private String status;

    public Funcionario(){}

    public Funcionario(String nome, String cargo, String observacao, String status) {
        this.nome = nome;
        this.cargo = cargo;
        this.observacao = observacao;
        this.status = status;
    }
}
