package com.usuariotarefa.Usuario.application.service;

import com.usuariotarefa.Usuario.application.api.controller.requests.UsuarioAlteracaoRequest;
import com.usuariotarefa.Usuario.application.api.controller.requests.UsuarioRequest;
import com.usuariotarefa.Usuario.application.api.controller.responses.UsuarioDetalhadoListResponse;
import com.usuariotarefa.Usuario.application.api.controller.responses.UsuarioListResponse;
import com.usuariotarefa.Usuario.application.api.controller.responses.UsuarioResponse;

import java.util.List;
import java.util.UUID;

public interface UsuarioService {
    UsuarioResponse criaUsuario(UsuarioRequest usuarioRequest);

    List<UsuarioListResponse> buscaTodosUsuarios();

    UsuarioDetalhadoListResponse buscaUsuarioPorId(UUID idUsuario);

    void deleteUsuarioPeloId(UUID idUsuario);

    void alteraUsuario(UUID idUsuario, UsuarioAlteracaoRequest usuarioAlteracaoRequest);
}
