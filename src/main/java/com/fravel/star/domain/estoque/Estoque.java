package com.fravel.star.domain.estoque;

import com.fravel.star.domain.Entidade;
import com.fravel.star.domain.medicamento.Medicamento;
import com.fravel.star.domain.ubs.UnidadeBasicaSaude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Table
@Entity
@Getter
@Setter
public class Estoque extends Entidade {
    @Column(nullable = false)
    @OneToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "ESTOQUE_MEDICAMENTO", joinColumns = @JoinColumn(name = "ESTOQUE_FK"),
//            inverseJoinColumns = @JoinColumn("MEDICAMENTO_FK"))
    private List<Medicamento> medicamento;
    @Column(nullable = false)
    @OneToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "ESTOQUE_UBS", joinColumns = @JoinColumn(name = "ESTOQUE_FK"),
//            inverseJoinColumns = @JoinColumn("UNIDADE_BASICA_SAUDE_FK"))
    private List<UnidadeBasicaSaude> unidadeBasicaSaude;
    private Long quantidade;

    public Estoque() {
    }
}
