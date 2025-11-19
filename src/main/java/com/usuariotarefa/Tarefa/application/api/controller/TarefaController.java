package com.usuariotarefa.Tarefa.application.api.controller;

import com.usuariotarefa.Tarefa.application.api.controller.requests.TarefaRequest;
import com.usuariotarefa.Tarefa.application.api.controller.requests.TarefaAlteracaoRequest;
import com.usuariotarefa.Tarefa.application.api.controller.requests.TarefaStatusUpdateRequest;
import com.usuariotarefa.Tarefa.application.api.controller.responses.TarefaListResponse;
import com.usuariotarefa.Tarefa.application.api.controller.responses.TarefaListUsuarioResponse;
import com.usuariotarefa.Tarefa.application.api.controller.responses.TarefaPorUsuarioResponse;
import com.usuariotarefa.Tarefa.application.api.controller.responses.TarefaResponse;
import com.usuariotarefa.Tarefa.application.service.TarefaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
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
        var tarefaResponse = tarefaService.salvaTarefa(idUsuario, tarefaRequest);
        log.info("[finish] TarefaController - salvaTarefa");
        return tarefaResponse;
    }

    @Override
    public List<TarefaListResponse> buscaTodasTarefas() {
        log.info("[start] TarefaController - buscaTodasTarefas");
        var listaDeTarefas = tarefaService.buscaTodasTarefas();
        log.info("[finish] TarefaController - buscaTodasTarefas");
        return listaDeTarefas;
    }

    @Override
    public List<TarefaListUsuarioResponse> buscaTodasTarefasDoUsuario(UUID idUsuario) {
        log.info("[start] TarefaController - buscaTodasTarefasDoUsuario");
        log.info("[idUsuario] {}", idUsuario);
        var listaDeTarefasDoUsuario = tarefaService.buscaTodasTarefasDoUsuario(idUsuario);
        log.info("[finish] TarefaController - buscaTodasTarefasDoUsuario");
        return listaDeTarefasDoUsuario;
    }

    @Override
    public void atualizaStatusTarefa(UUID idTarefa, TarefaStatusUpdateRequest statusRequest) {
        log.info("[start] TarefaController - atualizaStatusTarefa");
        log.info("[idTarefa] {}", idTarefa);
        tarefaService.atualizaStatusTarefa(idTarefa, statusRequest.getStatus());
        log.info("[finish] TarefaController - atualizaStatusTarefa");
    }

    @Override
    public TarefaPorUsuarioResponse buscaTarefaPorId(UUID idTarefa) {
        log.info("[start] TarefaController - buscaTarefaPorId");
        log.info("[idTarefa] {}", idTarefa);
        var tarefaPorUsuarioResponse = tarefaService.buscaTarefaPorId(idTarefa);
        log.info("[finish] TarefaController - buscaTarefaPorId");
        return tarefaPorUsuarioResponse;
    }

    @Override
    public void alteraTarefa(UUID idTarefa, TarefaAlteracaoRequest tarefaAlteracaoRequest) {
        log.info("[start] TarefaController - alteraTarefa");
        log.info("[idTarefa] {}", idTarefa);
        tarefaService.alteraTarefa(idTarefa, tarefaAlteracaoRequest);
        log.info("[finish] TarefaController - alteraTarefa");
    }

    @Override
    public void deletaTarefa(UUID idTarefa) {
        log.info("[start] TarefaController - deletaTarefa");
        log.info("[idTarefa] {}", idTarefa);
        tarefaService.deletaTarefa(idTarefa);
        log.info("[finish] TarefaController - deletaTarefa");
    }
}
