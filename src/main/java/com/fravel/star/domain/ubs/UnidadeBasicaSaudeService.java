package com.fravel.star.domain.ubs;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadeBasicaSaudeService {
    private final UnidadeBasicaSaudeRepository unidadeBasicaSaudeRepository;

    public UnidadeBasicaSaudeService(UnidadeBasicaSaudeRepository unidadeBasicaSaudeRepository) {
        this.unidadeBasicaSaudeRepository = unidadeBasicaSaudeRepository;
    }

    public Page<UnidadeBasicaSaude> listPageable(Pageable pageable) {
        return this.unidadeBasicaSaudeRepository.findAll(pageable);
    }

    public List<UnidadeBasicaSaude> list() {
        return unidadeBasicaSaudeRepository.findAll();
    }

    public UnidadeBasicaSaude find(Long id) {
        return unidadeBasicaSaudeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("UBS não encontrado."));
    }

    public UnidadeBasicaSaude edit(Long id, UnidadeBasicaSaude editado) {
        UnidadeBasicaSaude ubs = find(id);
        ubs.setEndereco(editado.getEndereco());
        ubs.setNome(editado.getNome());
        ubs.setSigla(editado.getSigla());
        ubs.setCodigo(editado.getCodigo());
        return save(ubs);
    }

    public UnidadeBasicaSaude save(UnidadeBasicaSaude funcionario) {
        return unidadeBasicaSaudeRepository.save(funcionario);
    }

    public void delete(Long id) {
        unidadeBasicaSaudeRepository.deleteById(id);
    }

    public List<UnidadeBasicaSaude> searchByName(String nome) {
        return unidadeBasicaSaudeRepository.findByNomeContainingIgnoreCase(nome);
    }
}
