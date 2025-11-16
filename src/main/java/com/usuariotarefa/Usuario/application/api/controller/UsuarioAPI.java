package com.usuariotarefa.Usuario.application.api.controller;

import com.usuariotarefa.Usuario.application.api.controller.requests.UsuarioRequest;
import com.usuariotarefa.Usuario.application.api.controller.responses.UsuarioDetalhadoListResponse;
import com.usuariotarefa.Usuario.application.api.controller.responses.UsuarioListResponse;
import com.usuariotarefa.Usuario.application.api.controller.responses.UsuarioResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/usuario")
public interface UsuarioAPI {

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    UsuarioResponse salvaUsuario(@Valid @RequestBody UsuarioRequest usuarioRequest);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<UsuarioListResponse> buscaTodosUsuarios();

    @GetMapping(value = "/{idUsuario}")
    @ResponseStatus(code = HttpStatus.OK)
    UsuarioDetalhadoListResponse buscaUsuarioPorId(@PathVariable UUID idUsuario);

    @DeleteMapping(value = "/{idUsuario}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deleteUsuarioPeloId(@PathVariable UUID idUsuario);

}
