package com.fravel.star.domain.ubs;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Endereco {
    private String rua;
    private String numero;
    private String complemento;
    private String codigoPostal;
    private String estado;
    private String pais;
    private String bairro;
    private String cidade;
}
