package com.usuariotarefa.Usuario.infra;

import com.usuariotarefa.Usuario.domain.Usuario;

import java.util.List;
import java.util.UUID;

public interface UsuarioRepository {
    Usuario salva(Usuario usuario);

    List<Usuario> buscaTodosUsuarios();

    Usuario buscaUsuarioPorId(UUID idUsuario);

    void deleteUsuarioPeloId(Usuario usuario);
}
