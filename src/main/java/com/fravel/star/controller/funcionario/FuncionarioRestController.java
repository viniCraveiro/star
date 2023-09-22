package com.fravel.star.controller.funcionario;

import com.fravel.star.domain.funcionario.Funcionario;
import com.fravel.star.domain.funcionario.FuncionarioService;
import org.apache.coyote.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.net.ssl.SSLSession;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioRestController {
    private final FuncionarioService funcionarioService;

    public FuncionarioRestController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @GetMapping()
    public ResponseEntity<Page<Funcionario>> listAllPageable(Pageable pageable) {
        Page<Funcionario> funcionarios = funcionarioService.funcionarioPaggeable(pageable);
        return new ResponseEntity<>(funcionarios, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> findOneById(@PathVariable long id) {
        Funcionario funcionario = funcionarioService.find(id);
        return new ResponseEntity<>(funcionario, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Funcionario> save(@RequestBody Funcionario novoFuncionario) {
        Funcionario funcionario = funcionarioService.save(novoFuncionario);
        return new ResponseEntity<>(funcionario, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> save(@PathVariable long id, @RequestBody Funcionario editado) {
        Funcionario funcionario = funcionarioService.edit(id, editado);
        return new ResponseEntity<>(funcionario, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable long id) {
        funcionarioService.delete(id);
        return new ResponseEntity<>(true, HttpStatus.NO_CONTENT);
    }
}
