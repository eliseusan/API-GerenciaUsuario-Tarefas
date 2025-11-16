package com.usuariotarefa.Usuario.application.api.controller.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class UsuarioAlteracaoRequest {
    @NotBlank
    private String nome;
    @NotBlank
    private String email;
    private String senha;
}
