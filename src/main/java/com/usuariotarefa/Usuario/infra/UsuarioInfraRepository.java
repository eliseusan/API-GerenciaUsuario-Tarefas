package com.usuariotarefa.Usuario.infra;

import com.usuariotarefa.Usuario.domain.Usuario;
import com.usuariotarefa.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class UsuarioInfraRepository implements UsuarioRepository {
    private final UsuarioSpringDataJPARepository usuarioSpringDataJPARepository;

    @Override
    public Usuario salva(Usuario usuario) {
        log.info("[start] UsuarioInfraRepository - salva");
        usuarioSpringDataJPARepository.save(usuario);
        log.info("[finish] UsuarioInfraRepository - salva");
        return usuario;
    }

    @Override
    public List<Usuario> buscaTodosUsuarios() {
        log.info("[start] UsuarioInfraRepository - buscaTodosUsuarios");
        var usuarios = usuarioSpringDataJPARepository.findAll();
        log.info("[finish] UsuarioInfraRepository - buscaTodosUsuarios");
        return usuarios;
    }

    @Override
    public Usuario buscaUsuarioPorId(UUID idUsuario) {
        log.info("[start] UsuarioInfraRepository - buscaUsuarioPorId");
        var usuario = usuarioSpringDataJPARepository.findById(idUsuario)
                .orElseThrow(() -> APIException.build(HttpStatus.BAD_REQUEST, "USUARIO NAO ENCONTRADO!"));
        log.info("[finish] UsuarioInfraRepository - buscaUsuarioPorId");
        return usuario;
    }

    @Override
    public void deleteUsuarioPeloId(Usuario usuario) {
        log.info("[start] UsuarioInfraRepository - deleteUsuarioPeloId");
        usuarioSpringDataJPARepository.delete(usuario);
        log.info("[finish] UsuarioInfraRepository - deleteUsuarioPeloId");
    }
}
