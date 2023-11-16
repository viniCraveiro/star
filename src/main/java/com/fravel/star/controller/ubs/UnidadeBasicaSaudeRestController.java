package com.fravel.star.controller.ubs;

import com.fravel.star.domain.ubs.UnidadeBasicaSaude;
import com.fravel.star.domain.ubs.UnidadeBasicaSaudeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/ubs")
public class UnidadeBasicaSaudeRestController {
    private final UnidadeBasicaSaudeService unidadeBasicaSaudeService;

    public UnidadeBasicaSaudeRestController(UnidadeBasicaSaudeService unidadeBasicaSaudeService) {
        this.unidadeBasicaSaudeService = unidadeBasicaSaudeService;
    }

    @Operation(summary = "Obtem lista paginada de UBS", tags = "Unidade básica de saúde")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de UBS encontrada.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Solicitação inválida"),
            @ApiResponse(responseCode = "404", description = "Não encontrado.")
    })
    @GetMapping()
    public ResponseEntity<Page<UnidadeBasicaSaude>> listAllPageable(Pageable pageable) {
        Page<UnidadeBasicaSaude> ubs = unidadeBasicaSaudeService.listPageable(pageable);
        return new ResponseEntity<>(ubs, HttpStatus.OK);
    }

    @Operation(summary = "Busca UBS por nome", tags = "Unidade básica de saúde")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de UBS encontrada.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Solicitação inválida"),
            @ApiResponse(responseCode = "404", description = "Não encontrado.")
    })
    @GetMapping("/search")
    public ResponseEntity<List<UnidadeBasicaSaude>> searchByName(@RequestParam String nome) {
        List<UnidadeBasicaSaude> ubs = unidadeBasicaSaudeService.searchByName(nome);
        return new ResponseEntity<>(ubs, HttpStatus.OK);
    }

    @Operation(summary = "Obtem uma UBS", tags = "Unidade básica de saúde")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Unidade basica de saúde encontrada.", content = {@Content(mediaType = "application" +
                    "/json")}),
            @ApiResponse(responseCode = "400", description = "Solicitação inválida"),
            @ApiResponse(responseCode = "404", description = "Não encontrado.")
    })
    @GetMapping("/{id}")
    public ResponseEntity<UnidadeBasicaSaude> findOneById(@PathVariable long id) {
        UnidadeBasicaSaude ubs = unidadeBasicaSaudeService.find(id);
        return new ResponseEntity<>(ubs, HttpStatus.OK);
    }

    @Operation(summary = "Cria uma Unidade básica de saúde", tags = "Unidade básica de saúde")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Unidade basica de saúde criada.", content = {@Content(mediaType = "application/json")}),
            @ApiResponse(responseCode = "400", description = "Solicitação inválida"),
            @ApiResponse(responseCode = "404", description = "Não encontrado.")
    })
    @PostMapping()
    public ResponseEntity<UnidadeBasicaSaude> save(@RequestBody UnidadeBasicaSaude novoUnidadeBasicaSaude) {
        UnidadeBasicaSaude ubs = unidadeBasicaSaudeService.save(novoUnidadeBasicaSaude);
        return new ResponseEntity<>(ubs, HttpStatus.CREATED);
    }

    @Operation(summary = "Edita uma UBS", tags = "Unidade básica de saúde")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Unidade basica de saúde editada com sucesso.", content = {@Content(mediaType =
                    "application/json")}),
            @ApiResponse(responseCode = "400", description = "Solicitação inválida"),
            @ApiResponse(responseCode = "404", description = "Não encontrado.")
    })
    @PutMapping("/{id}")
    public ResponseEntity<UnidadeBasicaSaude> edit(@PathVariable long id, @RequestBody UnidadeBasicaSaude editado) {
        UnidadeBasicaSaude ubs = unidadeBasicaSaudeService.edit(id, editado);
        return new ResponseEntity<>(ubs, HttpStatus.OK);
    }

    @Operation(summary = "Remove uma UBS", tags = "Unidade básica de saúde")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Unidade basica de saúde removida.", content = {@Content(mediaType = "application/json"
            )}),
            @ApiResponse(responseCode = "400", description = "Solicitação inválida"),
            @ApiResponse(responseCode = "404", description = "Não encontrado.")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable long id) {
        unidadeBasicaSaudeService.delete(id);
        return new ResponseEntity<>(true, HttpStatus.NO_CONTENT);
    }
}
