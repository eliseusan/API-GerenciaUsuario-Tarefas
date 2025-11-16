package com.usuariotarefa.Tarefa.application.api.controller;

import com.usuariotarefa.Tarefa.application.api.controller.requests.TarefaRequest;
import com.usuariotarefa.Tarefa.application.api.controller.responses.TarefaResponse;
import com.usuariotarefa.Tarefa.application.service.TarefaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
@Log4j2
@RestController
@RequiredArgsConstructor
public class TarefaController implements TarefaAPI {
    private final TarefaService tarefaService;

    @Override
    public TarefaResponse salvaTarefa(UUID idUsuario, TarefaRequest tarefaRequest) {
        log.info("[start] TarefaController - salvaTarefa");
        log.info("[idUsuario] {}", idUsuario);
        var tarefaResponse = tarefaService.salvaTarefa(idUsuario,tarefaRequest);
        log.info("[finish] TarefaController - salvaTarefa");
        return tarefaResponse;
    }
}
