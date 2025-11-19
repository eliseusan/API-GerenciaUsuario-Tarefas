package com.usuariotarefa.Tarefa.application.api.controller.responses;

import com.usuariotarefa.Tarefa.domain.Tarefa;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
public class TarefaResponse {
    private UUID idTarefa ;

    public TarefaResponse(Tarefa tarefa) {
        this.idTarefa = tarefa.getIdTarefa();
    }
}
