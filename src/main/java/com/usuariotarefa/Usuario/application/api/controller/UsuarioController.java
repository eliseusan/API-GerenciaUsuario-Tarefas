package com.usuariotarefa.Usuario.application.api.controller;

import com.usuariotarefa.Usuario.application.api.controller.requests.UsuarioAlteracaoRequest;
import com.usuariotarefa.Usuario.application.api.controller.requests.UsuarioRequest;
import com.usuariotarefa.Usuario.application.api.controller.responses.UsuarioDetalhadoListResponse;
import com.usuariotarefa.Usuario.application.api.controller.responses.UsuarioListResponse;
import com.usuariotarefa.Usuario.application.api.controller.responses.UsuarioResponse;
import com.usuariotarefa.Usuario.application.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;
@Log4j2
@RestController
@RequiredArgsConstructor
public class UsuarioController implements UsuarioAPI {

    private final UsuarioService usuarioService;

    @Override
    public UsuarioResponse salvaUsuario(UsuarioRequest usuarioRequest) {
        log.info("[start] UsuarioController - salvaUsuario");
        var usuarioResponse = usuarioService.criaUsuario(usuarioRequest);
        log.info("[finish] UsuarioController - salvaUsuario");
        return usuarioResponse;
    }

    @Override
    public List<UsuarioListResponse> buscaTodosUsuarios() {
        log.info("[start] UsuarioController - buscaTodosUsuarios");
        var usuarioListResponse = usuarioService.buscaTodosUsuarios();
        log.info("[finish] UsuarioController - buscaTodosUsuarios");
        return usuarioListResponse;
    }

    @Override
    public UsuarioDetalhadoListResponse buscaUsuarioPorId(UUID idUsuario) {
        log.info("[start] UsuarioController - buscaUsuarioPorId");
        var usuarioDetalhadoListResponse = usuarioService.buscaUsuarioPorId(idUsuario);
        log.info("[finish] UsuarioController - buscaUsuarioPorId");
        return usuarioDetalhadoListResponse;
    }

    @Override
    public void deleteUsuarioPeloId(UUID idUsuario){
        log.info("[start] UsuarioController - deleteUsuarioPeloId");
        log.info("[idUsuario] {}", idUsuario);
        usuarioService.deleteUsuarioPeloId(idUsuario);
        log.info("[finish] UsuarioController - deleteUsuarioPeloId");

    }

    @Override
    public void alteraUsuario(UUID idUsuario, UsuarioAlteracaoRequest usuarioAlteracaoRequest) {
        log.info("[start] UsuarioController - alteraUsuario");
        log.info("[idUsuario] {}", idUsuario);
        usuarioService.alteraUsuario(idUsuario, usuarioAlteracaoRequest);
        log.info("[finish] UsuarioController - alteraUsuario");





    }
}
