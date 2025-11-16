package com.usuariotarefa.Usuario.application.api.controller.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class UsuarioRequest {
    @NotBlank
    private String nome;
    @NotBlank
    @Email(message = "Email inválido")
    private String email;
    @NotBlank
    @Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres")
    private String senha;

}
