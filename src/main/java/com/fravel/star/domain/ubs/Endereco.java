package com.fravel.star.domain.ubs;

import com.fravel.star.domain.Entidade;
import com.fravel.star.domain.IEntidade;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Table
public class Endereco extends Entidade {
    private String rua;
    private String numero;
    private String complemento;
    private String codigoPostal;
    private String estado;
    private String pais;
    private String bairro;
}
