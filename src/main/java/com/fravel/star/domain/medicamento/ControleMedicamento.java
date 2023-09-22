package com.fravel.star.domain.medicamento;

import com.fravel.star.domain.Entidade;
import com.fravel.star.domain.estoque.Estoque;
import com.fravel.star.domain.usuario.Usuario;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Entity
@Table
@Getter
@Setter
public class ControleMedicamento extends Entidade {

    @ManyToOne
    @JoinColumn(name = "estoque_fk")
    private Estoque estoque;
    @ManyToOne
    @JoinColumn(name = "usuario_fk")
    private Usuario usuario;
    private Integer quantidade;
    private ZonedDateTime dataRegistro;
    private String observacao;
    private String receita;

    public ControleMedicamento() {
    }

    public ControleMedicamento(Estoque estoque, Usuario usuario, Integer quantidade, ZonedDateTime dataRegistro, String observacao, String receita) {
        this.estoque = estoque;
        this.usuario = usuario;
        this.quantidade = quantidade;
        this.dataRegistro = dataRegistro;
        this.observacao = observacao;
        this.receita = receita;
    }
}
