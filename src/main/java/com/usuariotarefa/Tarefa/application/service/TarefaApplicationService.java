package com.usuariotarefa.Tarefa.application.service;

import com.usuariotarefa.Tarefa.application.api.controller.requests.TarefaRequest;
import com.usuariotarefa.Tarefa.application.api.controller.responses.TarefaResponse;
import com.usuariotarefa.Tarefa.application.repository.TarefaRepository;
import com.usuariotarefa.Tarefa.domain.Tarefa;
import com.usuariotarefa.Usuario.application.repository.UsuarioRepository;
import com.usuariotarefa.Usuario.domain.Usuario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
@RequiredArgsConstructor
@Log4j2
public class TarefaApplicationService implements TarefaService {
    private final TarefaRepository tarefaRepository;
    private final UsuarioRepository usuarioRepository;

    @Override
    public TarefaResponse salvaTarefa(UUID idUsuario, TarefaRequest tarefaRequest) {
        log.info("[start] TarefaApplicationService - salvaTarefa");
        Usuario usuario = usuarioRepository.buscaUsuarioPorId(idUsuario);
        Tarefa tarefa = tarefaRepository.salvaTarefa(new Tarefa(usuario, tarefaRequest));
        log.info("[finish] TarefaApplicationService - salvaTarefa");
        return new TarefaResponse(tarefa);
    }
}
