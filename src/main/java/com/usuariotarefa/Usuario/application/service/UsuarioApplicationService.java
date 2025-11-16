package com.usuariotarefa.Usuario.application.service;

import com.usuariotarefa.Usuario.application.api.controller.requests.UsuarioAlteracaoRequest;
import com.usuariotarefa.Usuario.application.api.controller.requests.UsuarioRequest;
import com.usuariotarefa.Usuario.application.api.controller.responses.UsuarioDetalhadoListResponse;
import com.usuariotarefa.Usuario.application.api.controller.responses.UsuarioListResponse;
import com.usuariotarefa.Usuario.application.api.controller.responses.UsuarioResponse;
import com.usuariotarefa.Usuario.domain.Usuario;
import com.usuariotarefa.Usuario.infra.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class UsuarioApplicationService implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Override
    public UsuarioResponse criaUsuario(UsuarioRequest usuarioRequest) {
        log.info("[start] UsuarioApplicationService - criaUsuario");
        Usuario usuario = usuarioRepository.salva(new Usuario(usuarioRequest));
        log.info("[finish] UsuarioApplicationService - criaUsuario");
        return new UsuarioResponse(usuario);
    }

    @Override
    public List<UsuarioListResponse> buscaTodosUsuarios() {
        log.info("[start] UsuarioApplicationService - buscaTodosUsuarios");
        var usuarios = usuarioRepository.buscaTodosUsuarios();
        log.info("[finish] UsuarioApplicationService - buscaTodosUsuarios");
        return UsuarioListResponse.converte(usuarios);
    }

    @Override
    public UsuarioDetalhadoListResponse buscaUsuarioPorId(UUID idUsuario) {
        log.info("[start] UsuarioApplicationService - buscaUsuarioPorId");
        var usuario = usuarioRepository.buscaUsuarioPorId(idUsuario);
        log.info("[finish] UsuarioApplicationService - buscaUsuarioPorId");
        return new UsuarioDetalhadoListResponse(usuario);
    }

    @Override
    public void deleteUsuarioPeloId(UUID idUsuario) {
        log.info("[start] UsuarioApplicationService - deleteUsuarioPeloId");
        Usuario usuario = usuarioRepository.buscaUsuarioPorId(idUsuario);
        usuarioRepository.deleteUsuarioPeloId(usuario);
        log.info("[start] UsuarioApplicationService - deleteUsuarioPeloId");
    }

    @Override
    public void alteraUsuario(UUID idUsuario, UsuarioAlteracaoRequest usuarioAlteracaoRequest) {
        log.info("[start] UsuarioApplicationService - alteraUsuario");
        Usuario usuario = usuarioRepository.buscaUsuarioPorId(idUsuario);
        usuario.altera(usuarioAlteracaoRequest);
        usuarioRepository.salva(usuario);
        log.info("[finish] UsuarioApplicationService - alteraUsuario");
    }
}
