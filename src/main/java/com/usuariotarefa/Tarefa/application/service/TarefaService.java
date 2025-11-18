package com.usuariotarefa.Tarefa.application.service;

import com.usuariotarefa.Tarefa.application.api.controller.requests.TarefaRequest;
import com.usuariotarefa.Tarefa.application.api.controller.responses.TarefaListResponse;
import com.usuariotarefa.Tarefa.application.api.controller.responses.TarefaResponse;

import java.util.List;
import java.util.UUID;

public interface TarefaService {
    TarefaResponse salvaTarefa(UUID idUsuario, TarefaRequest tarefaRequest);

    List<TarefaListResponse> buscaTodasTarefas();
}
