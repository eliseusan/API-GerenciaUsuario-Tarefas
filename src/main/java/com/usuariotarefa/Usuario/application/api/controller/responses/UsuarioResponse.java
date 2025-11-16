package com.usuariotarefa.Usuario.application.api.controller.responses;

import com.usuariotarefa.Usuario.domain.Usuario;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
public class UsuarioResponse {
    private UUID idUsuario;

    public UsuarioResponse(Usuario usuario) {
        this.idUsuario = usuario.getIdUsuario();
    }
}
