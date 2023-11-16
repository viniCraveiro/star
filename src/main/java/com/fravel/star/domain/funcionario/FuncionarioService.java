package com.fravel.star.domain.funcionario;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public Page<Funcionario> funcionarioPaggeable(Pageable pageable) {
        return this.funcionarioRepository.findAll(pageable);
    }

    public List<Funcionario> list() {
        return funcionarioRepository.findAll();
    }

    public Funcionario find(Long id) {
        return funcionarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Funcionário não encontrado."));
    }

    public Funcionario edit(Long id, Funcionario editado) {
        Funcionario funcionario = find(id);
        funcionario.setNome(editado.getNome());
        funcionario.setCargo(editado.getCargo());
        funcionario.setObservacao(editado.getObservacao());
        funcionario.setStatus(editado.getStatus());
        return save(funcionario);
    }

    public Funcionario save(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public void delete(Long id) {
        funcionarioRepository.deleteById(id);
    }


}
