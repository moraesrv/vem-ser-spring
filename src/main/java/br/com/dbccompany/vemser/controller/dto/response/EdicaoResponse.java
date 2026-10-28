package br.com.dbccompany.vemser.controller.dto.response;

import java.time.Instant;

public record EdicaoResponse(
    Long id,
    String nome,
    boolean ativo,
    Instant dataCriacao
) {}
