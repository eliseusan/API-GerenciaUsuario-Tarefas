package com.usuariotarefa.Tarefa.application.api.controller.requests;

import com.usuariotarefa.Tarefa.domain.StatusTarefa.StatusTarefa;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class TarefaStatusUpdateRequest {
    @NotNull
    private StatusTarefa status;
}