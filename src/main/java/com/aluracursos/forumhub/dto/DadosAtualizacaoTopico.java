package com.aluracursos.forumhub.dto;

public record DadosAtualizacaoTopico(
        String titulo,
        String mensagem,
        String autor,
        String curso
) {}