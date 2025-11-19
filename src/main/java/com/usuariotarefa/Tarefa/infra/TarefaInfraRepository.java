package com.usuariotarefa.Tarefa.infra;

import com.usuariotarefa.Tarefa.application.repository.TarefaRepository;
import com.usuariotarefa.Tarefa.domain.Tarefa;
import com.usuariotarefa.Usuario.domain.Usuario;
import com.usuariotarefa.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class TarefaInfraRepository implements TarefaRepository {

    private final TarefaSpringDataJPARepository tarefaSpringDataJPARepository;

    @Override
    public Tarefa salvaTarefa(Tarefa tarefa) {
        log.info("[start] TarefaInfraRepository - salvaTarefa");
        tarefaSpringDataJPARepository.save(tarefa);
        log.info("[finish] TarefaInfraRepository - salvaTarefa");
        return tarefa;
    }

    @Override
    public List<Tarefa> buscaTodasTarefas() {
        log.info("[start] TarefaInfraRepository - buscaTodasTarefas");
        List<Tarefa> tarefas = tarefaSpringDataJPARepository.findAll();
        log.info("[finish] TarefaInfraRepository - buscaTodasTarefas");
        return tarefas;
    }

    @Override
    public List<Tarefa> buscaTodasTarefasDoUsuario(Usuario usuario) {
        log.info("[start] TarefaInfraRepository - buscaTodasTarefasDoUsuario");
        List<Tarefa> tarefas = tarefaSpringDataJPARepository.findByUsuario(usuario);
        log.info("[finish] TarefaInfraRepository - buscaTodasTarefasDoUsuario");
        return tarefas;
    }

    @Override
    public Tarefa buscaTarefaPorId(UUID idTarefa) {
        log.info("[start] TarefaInfraRepository - buscaTarefaPorId");
        Tarefa tarefa = tarefaSpringDataJPARepository.findById(idTarefa)
                .orElseThrow(() -> APIException.build(HttpStatus.BAD_REQUEST, "TAREFA NAO ENCONTRADA!"));
        log.info("[finish] TarefaInfraRepository - buscaTarefaPorId");
        return tarefa;
    }

    @Override
    public void deletaTarefa(Tarefa tarefa) {
        log.info("[start] TarefaInfraRepository - deletaTarefa");
        tarefaSpringDataJPARepository.delete(tarefa);
        log.info("[finish] TarefaInfraRepository - deletaTarefa");
    }
}
