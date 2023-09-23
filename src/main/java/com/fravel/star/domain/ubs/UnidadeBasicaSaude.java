package com.fravel.star.domain.ubs;

import com.fravel.star.domain.Entidade;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class UnidadeBasicaSaude extends Entidade {
    private String codigo;
    private String nome;
    private String sigla;
    private Endereco endereco;
}
