package com.aluracursos.forumhub.dto;

import jakarta.validation.constraints.NotBlank;

public record DadosLogin(
        @NotBlank String email,
        @NotBlank String senha
) {}