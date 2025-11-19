package com.usuariotarefa.Tarefa.application.api.controller;

import com.usuariotarefa.Tarefa.application.api.controller.requests.TarefaRequest;
import com.usuariotarefa.Tarefa.application.api.controller.requests.TarefaAlteracaoRequest;
import com.usuariotarefa.Tarefa.application.api.controller.requests.TarefaStatusUpdateRequest;
import com.usuariotarefa.Tarefa.application.api.controller.responses.TarefaListResponse;
import com.usuariotarefa.Tarefa.application.api.controller.responses.TarefaListUsuarioResponse;
import com.usuariotarefa.Tarefa.application.api.controller.responses.TarefaPorUsuarioResponse;
import com.usuariotarefa.Tarefa.application.api.controller.responses.TarefaResponse;
import com.usuariotarefa.Usuario.application.api.controller.requests.UsuarioAlteracaoRequest;
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
    List<TarefaListUsuarioResponse> buscaTodasTarefasDoUsuario(@PathVariable UUID idUsuario);

    @PatchMapping(value= "/{idTarefa}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void atualizaStatusTarefa(@PathVariable UUID idTarefa,
                              @Valid @RequestBody TarefaStatusUpdateRequest statusRequest);

    @GetMapping(value = "{idTarefa}")
    @ResponseStatus(code = HttpStatus.OK)
    TarefaPorUsuarioResponse buscaTarefaPorId(@PathVariable UUID idTarefa);

    @PatchMapping(value = "/{idTarefa}/altera")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void alteraTarefa(@PathVariable UUID idTarefa,
                      @Valid @RequestBody TarefaAlteracaoRequest tarefaAlteracaoRequest);

    @DeleteMapping(value = "/{idTarefa}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deletaTarefa(@PathVariable UUID idTarefa);
}
