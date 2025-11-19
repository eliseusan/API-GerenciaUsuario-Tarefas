package com.usuariotarefa.Tarefa.domain;

import com.usuariotarefa.Tarefa.application.api.controller.requests.TarefaRequest;
import com.usuariotarefa.Tarefa.domain.StatusTarefa.StatusTarefa;
import com.usuariotarefa.Usuario.domain.Usuario;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "idTarefa", updatable = false, unique = true, nullable = false)
    private UUID idTarefa ;

    @Column(nullable = false)
    private String titulo;

    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusTarefa status;

    @CreationTimestamp
    private LocalDateTime dataHoraDoCadastro ;
    private LocalDateTime dataHoraDaUltimaAlteracao ;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    public Tarefa(Usuario usuario, TarefaRequest tarefaRequest) {
        this.titulo = tarefaRequest.getTitulo();
        this.descricao = tarefaRequest.getDescricao();
        this.status = StatusTarefa.EM_ANDAMENTO;
        this.dataHoraDoCadastro = LocalDateTime.now();
        this.usuario = usuario;
    }

    public void alteraStatus(Enum status) {
        this.status = StatusTarefa.valueOf(status.toString());
        this.dataHoraDaUltimaAlteracao = LocalDateTime.now();
    }
}