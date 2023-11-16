package com.fravel.star.domain.ubs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnidadeBasicaSaudeRepository extends JpaRepository<UnidadeBasicaSaude, Long> {
    List<UnidadeBasicaSaude> findByNomeContainingIgnoreCase(String nome);
}
