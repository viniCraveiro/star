package com.fravel.star.domain.disponibilidade;

import com.fravel.star.domain.Entidade;
import com.fravel.star.domain.funcionario.Funcionario;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Entity
@Getter
@Setter
@Table
public class Disponibilidade extends Entidade {
    private String diaSemana;
    private ZonedDateTime entrada;
    private ZonedDateTime saida;
    @OneToOne
    @JoinColumn(name = "fk_funcionario")
    private Funcionario funcionario;
}
