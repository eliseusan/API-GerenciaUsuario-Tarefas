package com.usuariotarefa.Tarefa.infra;

import com.usuariotarefa.Tarefa.application.repository.TarefaRepository;
import com.usuariotarefa.Tarefa.domain.Tarefa;
import com.usuariotarefa.Usuario.domain.Usuario;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

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

}
