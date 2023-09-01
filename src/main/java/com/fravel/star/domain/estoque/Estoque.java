package com.fravel.star.domain.estoque;

import com.fravel.star.domain.Entidade;
import com.fravel.star.domain.medicamento.Medicamento;
import com.fravel.star.domain.ubs.UnidadeBasicaSaude;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Table
@Entity
@Getter
@Setter
public class Estoque extends Entidade {
    private List<Medicamento> medicamento;
    private List<UnidadeBasicaSaude> unidadeBasicaSaude;
    private Long quantidade;

    public Estoque() {
    }
}
