package com.usuariotarefa.Tarefa.application.api.controller;

import com.usuariotarefa.Tarefa.application.api.controller.requests.TarefaRequest;
import com.usuariotarefa.Tarefa.application.api.controller.responses.TarefaListResponse;
import com.usuariotarefa.Tarefa.application.api.controller.responses.TarefaResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/tarefa")
public interface TarefaAPI {

    @PostMapping(value = "/{idUsuario}")
    @ResponseStatus(code = HttpStatus.CREATED)
    TarefaResponse salvaTarefa(@Valid @PathVariable UUID idUsuario, @RequestBody TarefaRequest tarefaRequest);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<TarefaListResponse> buscaTodasTarefas();

    @GetMapping(value = "usuario/{idUsuario}")
    @ResponseStatus(code = HttpStatus.OK)
    List<TarefaListResponse> buscaTodasTarefas(@PathVariable UUID idUsuario);
}
