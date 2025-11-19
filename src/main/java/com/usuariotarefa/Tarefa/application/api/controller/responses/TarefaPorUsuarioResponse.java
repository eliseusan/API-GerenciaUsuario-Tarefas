package com.usuariotarefa.Tarefa.application.api.controller.responses;

import com.usuariotarefa.Tarefa.domain.StatusTarefa.StatusTarefa;
import com.usuariotarefa.Tarefa.domain.Tarefa;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@ToString
public class TarefaPorUsuarioResponse {
    private UUID idTarefa;
    private String titulo;
    private String descricao;
    private StatusTarefa status;
    private LocalDateTime dataHoraDoCadastro;
    private LocalDateTime dataHoraDaUltimaAlteracao;

    public TarefaPorUsuarioResponse(Tarefa tarefa) {
        this.idTarefa = tarefa.getIdTarefa();
        this.titulo = tarefa.getTitulo();
        this.descricao = tarefa.getDescricao();
        this.status = tarefa.getStatus();
        this.dataHoraDoCadastro = tarefa.getDataHoraDoCadastro();
        this.dataHoraDaUltimaAlteracao = tarefa.getDataHoraDaUltimaAlteracao();
    }
}
