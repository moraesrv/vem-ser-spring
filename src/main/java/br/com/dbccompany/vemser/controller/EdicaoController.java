package br.com.dbccompany.vemser.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.dbccompany.vemser.controller.dto.response.EdicaoResponse;
import br.com.dbccompany.vemser.controller.dto.request.EdicaoRequest;
import lombok.extern.slf4j.Slf4j;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Slf4j
@RestController 
@RequestMapping("/edicoes")
public class EdicaoController {

    @PostMapping
    public ResponseEntity<EdicaoResponse> inserir(@RequestBody EdicaoRequest request) {
        log.info("Requisição POST /edicoes recebida com sucesso.");
        
        log.info("==> Dados da requisição: {}", request);

        var response = new EdicaoResponse(
            1L,
            request.nome(),
            true,
            Instant.now()
        );
        
        log.info("Requisição POST /edicoes processada com sucesso.");
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EdicaoResponse> atualizar(@PathVariable Long id, @RequestBody EdicaoRequest request) {
        log.info("Requisição PUT /edicoes/{} recebida com sucesso.", id);
        log.info("==> Dados da requisição: {}", request);

        var response = new EdicaoResponse(
            id,
            request.nome(),
            true,
            Instant.now()
        );

        log.info("Requisição PUT /edicoes/{} processada com sucesso.", id);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        log.info("Requisição DELETE /edicoes/{} recebida com sucesso.", id);

        log.info("Requisição DELETE /edicoes/{} processada com sucesso.", id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<EdicaoResponse>> listar(@RequestParam(required = false) Boolean ativo) {
        log.info("Requisição GET /edicoes recebida com sucesso.");
        log.info("==> Filtro ativo: {}", ativo);

        List<EdicaoResponse> edicoes = new ArrayList<>();
        for (int i=1; i<=18; i++) {
            edicoes.add(new EdicaoResponse(
                (long) i,
                "Vem Ser " + i,
                (i % 2 == 0),
                Instant.now()
            ));
        }

        if (ativo != null) {
            edicoes = edicoes.stream()
                .filter(e -> e.ativo() == ativo)
                .toList();
        }

        log.info("Requisição GET /edicoes processada com sucesso.");
        return ResponseEntity.ok(edicoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EdicaoResponse> consultar(@PathVariable Long id) {
        log.info("Requisição GET /edicoes/{} recebida com sucesso.", id);
        
        var response = new EdicaoResponse(
            id,
            "Vem Ser " + id,
            true,
            Instant.now()
        );
        
        log.info("Requisição GET /edicoes/{} processada com sucesso.", id);
        return ResponseEntity.ok(response);
    }

}
