package com.usuariotarefa.Tarefa.application.api.controller.responses;

import com.usuariotarefa.Tarefa.domain.StatusTarefa.StatusTarefa;
import com.usuariotarefa.Tarefa.domain.Tarefa;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@ToString
public class TarefaListUsuarioResponse {
    private final UUID idTarefa;
    private final UUID idUsuario;
    private String titulo;
    private String descricao;
    private StatusTarefa status;
    private LocalDateTime dataHoraDoCadastro;
    private LocalDateTime dataHoraDaUltimaAlteracao;

    public TarefaListUsuarioResponse(Tarefa tarefa) {
        this.idTarefa = tarefa.getIdTarefa();
        this.idUsuario = tarefa.getUsuario().getIdUsuario();
        this.titulo = tarefa.getTitulo();
        this.descricao = tarefa.getDescricao();
        this.status = tarefa.getStatus();
        this.dataHoraDoCadastro = tarefa.getDataHoraDoCadastro();
        this.dataHoraDaUltimaAlteracao = tarefa.getDataHoraDaUltimaAlteracao();
    }

    public static List<TarefaListUsuarioResponse> converte(List<Tarefa> tarefas) {
        return tarefas.stream()
                .map(TarefaListUsuarioResponse::new)
                .collect(Collectors.toList());
    }
}
