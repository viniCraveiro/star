package com.fravel.star.domain.requisicao;

import com.fravel.star.domain.Entidade;
import com.fravel.star.domain.ubs.Endereco;
import com.fravel.star.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Entity
@Table
@Getter
@Setter
public class ConsultaAgendamento extends Entidade {
    private Endereco endereco;
    @ManyToOne
    private Usuario usuario;
    private TipoConsulta tipoConsulta;
    private ZonedDateTime agendamento;
    private String observacao;

    public ConsultaAgendamento() {
    }

    public ConsultaAgendamento(Endereco endereco, Usuario usuario, TipoConsulta tipoConsulta, ZonedDateTime agendamento, String observacao) {
        this.endereco = endereco;
        this.usuario = usuario;
        this.tipoConsulta = tipoConsulta;
        this.agendamento = agendamento;
        this.observacao = observacao;
    }
}
