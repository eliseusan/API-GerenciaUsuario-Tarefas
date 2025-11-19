package com.usuariotarefa.Tarefa.application.api.controller.responses;

import com.usuariotarefa.Tarefa.domain.StatusTarefa.StatusTarefa;
import com.usuariotarefa.Tarefa.domain.Tarefa;
import com.usuariotarefa.Usuario.application.api.controller.responses.UsuarioListResponse;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@ToString
public class TarefaListResponse {

    private UUID idTarefa ;
    private String titulo;
    private String descricao;
    private StatusTarefa status;
    private LocalDateTime dataHoraDoCadastro ;
    private LocalDateTime dataHoraDaUltimaAlteracao ;

    public TarefaListResponse(Tarefa tarefa) {
        this.idTarefa = tarefa.getIdTarefa();
        this.titulo = tarefa.getTitulo();
        this.descricao = tarefa.getDescricao();
        this.status = tarefa.getStatus();
        this.dataHoraDoCadastro = tarefa.getDataHoraDoCadastro();
        this.dataHoraDaUltimaAlteracao = tarefa.getDataHoraDaUltimaAlteracao();
    }

    public static List<TarefaListResponse> converte(List<Tarefa> tarefas) {
        return tarefas.stream()
                .map(TarefaListResponse::new)
                .collect(Collectors.toList());
    }
}
