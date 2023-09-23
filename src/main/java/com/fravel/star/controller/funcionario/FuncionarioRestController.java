package com.fravel.star.controller.funcionario;

import com.fravel.star.domain.funcionario.Funcionario;
import com.fravel.star.domain.funcionario.FuncionarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioRestController {
    private final FuncionarioService funcionarioService;

    public FuncionarioRestController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @Operation(summary = "Obtem lista paginada de Funcionarios", tags = "Funcionario")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de funcionario encontrada.", content =
                    {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Solicitação inválida"),
            @ApiResponse(responseCode = "404", description = "Não encontrado.")
    })
    @GetMapping()
    public ResponseEntity<Page<Funcionario>> listAllPageable(Pageable pageable) {
        Page<Funcionario> funcionarios = funcionarioService.funcionarioPaggeable(pageable);
        return new ResponseEntity<>(funcionarios, HttpStatus.OK);
    }

    @Operation(summary = "Obtem um Funcionario", tags = "Funcionario")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Funcionario encontrada.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Solicitação inválida"),
            @ApiResponse(responseCode = "404", description = "Não encontrado.")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> findOneById(@PathVariable long id) {
        Funcionario funcionario = funcionarioService.find(id);
        return new ResponseEntity<>(funcionario, HttpStatus.OK);
    }

    @Operation(summary = "Cria um Funcionario", tags = "Funcionario")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Funcionario criado.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Solicitação inválida"),
            @ApiResponse(responseCode = "404", description = "Não encontrado.")
    })
    @PostMapping()
    public ResponseEntity<Funcionario> save(@RequestBody Funcionario novoFuncionario) {
        Funcionario funcionario = funcionarioService.save(novoFuncionario);
        return new ResponseEntity<>(funcionario, HttpStatus.CREATED);
    }

    @Operation(summary = "Edita um Funcionario", tags = "Funcionario")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Funcionario editado.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Solicitação inválida"),
            @ApiResponse(responseCode = "404", description = "Não encontrado.")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> edit(@PathVariable long id, @RequestBody Funcionario editado) {
        Funcionario funcionario = funcionarioService.edit(id, editado);
        return new ResponseEntity<>(funcionario, HttpStatus.OK);
    }

    @Operation(summary = "Deleta um Funcionario", tags = "Funcionario")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Funcionario encontrada.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Solicitação inválida"),
            @ApiResponse(responseCode = "404", description = "Não encontrado.")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable long id) {
        funcionarioService.delete(id);
        return new ResponseEntity<>(true, HttpStatus.NO_CONTENT);
    }
}
