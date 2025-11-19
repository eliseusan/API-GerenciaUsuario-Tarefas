package com.usuariotarefa.Tarefa.application.service;

import com.usuariotarefa.Tarefa.application.api.controller.requests.TarefaRequest;
import com.usuariotarefa.Tarefa.application.api.controller.requests.TarefaAlteracaoRequest;
import com.usuariotarefa.Tarefa.application.api.controller.responses.TarefaListResponse;
import com.usuariotarefa.Tarefa.domain.StatusTarefa.StatusTarefa;
import com.usuariotarefa.Tarefa.application.api.controller.responses.TarefaListUsuarioResponse;
import com.usuariotarefa.Tarefa.application.api.controller.responses.TarefaPorUsuarioResponse;
import com.usuariotarefa.Tarefa.application.api.controller.responses.TarefaResponse;

import java.util.List;
import java.util.UUID;

public interface TarefaService {
    TarefaResponse salvaTarefa(UUID idUsuario, TarefaRequest tarefaRequest);

    List<TarefaListResponse> buscaTodasTarefas();

    List<TarefaListUsuarioResponse> buscaTodasTarefasDoUsuario(UUID idUsuario);

    void atualizaStatusTarefa(UUID idTarefa, StatusTarefa status);

    TarefaPorUsuarioResponse buscaTarefaPorId(UUID idTarefa);

    void alteraTarefa(UUID idTarefa, TarefaAlteracaoRequest tarefaAlteracaoRequest);

    void deletaTarefa(UUID idTarefa);
}
