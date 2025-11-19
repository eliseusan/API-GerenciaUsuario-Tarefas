package com.usuariotarefa.Tarefa.application.service;

import com.usuariotarefa.Tarefa.application.api.controller.requests.TarefaRequest;
import com.usuariotarefa.Tarefa.application.api.controller.responses.TarefaListResponse;
import com.usuariotarefa.Tarefa.application.api.controller.responses.TarefaListUsuarioResponse;
import com.usuariotarefa.Tarefa.application.api.controller.responses.TarefaPorUsuarioResponse;
import com.usuariotarefa.Tarefa.application.api.controller.responses.TarefaResponse;
import com.usuariotarefa.Tarefa.application.repository.TarefaRepository;
import com.usuariotarefa.Tarefa.domain.StatusTarefa.StatusTarefa;
import com.usuariotarefa.Tarefa.domain.Tarefa;
import com.usuariotarefa.Usuario.application.api.controller.responses.UsuarioListResponse;
import com.usuariotarefa.Usuario.application.repository.UsuarioRepository;
import com.usuariotarefa.Usuario.domain.Usuario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
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

    @Override
    public List<TarefaListResponse> buscaTodasTarefas() {
        log.info("[start] TarefaApplicationService - buscaTodasTarefas");
        List<Tarefa> tarefas = tarefaRepository.buscaTodasTarefas();
        log.info("[finish] TarefaApplicationService - buscaTodasTarefas");
        return TarefaListResponse.converte(tarefas);

    }

    @Override
    public List<TarefaListUsuarioResponse> buscaTodasTarefasDoUsuario(UUID idUsuario) {
        log.info("[start] TarefaApplicationService - buscaTodasTarefasDoUsuario");
        log.info("[idUsuario] {}", idUsuario);
        Usuario usuario = usuarioRepository.buscaUsuarioPorId(idUsuario);
        List<Tarefa> tarefas = tarefaRepository.buscaTodasTarefasDoUsuario(usuario);
        log.info("[finish] TarefaApplicationService - buscaTodasTarefasDoUsuario");
        return TarefaListUsuarioResponse.converte(tarefas);
    }

    @Override
    public void atualizaStatusTarefa(UUID idTarefa, StatusTarefa status) {
        log.info("[start] TarefaApplicationService - atualizaStatusTarefa");
        log.info("[idTarefa] {}", idTarefa);
        log.info("[status] {}", status);
        Tarefa tarefa = tarefaRepository.buscaTarefaPorId(idTarefa);
        tarefa.alteraStatus(status);
        tarefaRepository.salvaTarefa(tarefa);
    }

    @Override
    public TarefaPorUsuarioResponse buscaTarefaPorId(UUID idTarefa) {
        log.info("[start] TarefaApplicationService - buscaTarefaPorId");
        log.info("[idTarefa] {}", idTarefa);
        Tarefa tarefa = tarefaRepository.buscaTarefaPorId(idTarefa);
        log.info("[finish] TarefaApplicationService - buscaTarefaPorId");
        return new TarefaPorUsuarioResponse(tarefa);
    }
}
