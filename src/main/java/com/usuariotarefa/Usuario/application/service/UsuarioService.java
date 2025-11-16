package com.usuariotarefa.Usuario.application.service;

import com.usuariotarefa.Usuario.application.api.controller.requests.UsuarioRequest;
import com.usuariotarefa.Usuario.application.api.controller.responses.UsuarioDetalhadoListResponse;
import com.usuariotarefa.Usuario.application.api.controller.responses.UsuarioListResponse;
import com.usuariotarefa.Usuario.application.api.controller.responses.UsuarioResponse;
import com.usuariotarefa.Usuario.domain.Usuario;

import java.util.List;
import java.util.UUID;

public interface UsuarioService {
    UsuarioResponse criaUsuario(UsuarioRequest usuarioRequest);

    List<UsuarioListResponse> buscaTodosUsuarios();

    UsuarioDetalhadoListResponse buscaUsuarioPorId(UUID idUsuario);
}
