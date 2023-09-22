package com.fravel.star.domain.ubs;

import com.fravel.star.domain.Entidade;
import com.fravel.star.domain.estoque.Estoque;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table
@Getter
@Setter
public class UnidadeBasicaSaude extends Entidade {
    private Endereco endereco;
    private String nome;
    private String sigla;
    private String codigo;
}
