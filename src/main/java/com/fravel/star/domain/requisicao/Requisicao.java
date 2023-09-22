package com.fravel.star.domain.requisicao;

import com.fravel.star.domain.Entidade;
import com.fravel.star.domain.funcionario.Funcionario;
import com.fravel.star.domain.medicamento.Medicamento;
import com.fravel.star.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table
public class Requisicao extends Entidade {
    @ManyToOne
    @JoinColumn(name = "fk_usuario")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "fk_medicamento")
    private Medicamento medicamento;
    @ManyToOne
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;
}
