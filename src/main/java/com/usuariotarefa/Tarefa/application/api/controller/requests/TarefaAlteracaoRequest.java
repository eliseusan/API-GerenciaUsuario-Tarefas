package com.usuariotarefa.Tarefa.application.api.controller.requests;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class TarefaAlteracaoRequest {
    @NotBlank
    private String titulo;
    @NotBlank
    private String descricao;
}