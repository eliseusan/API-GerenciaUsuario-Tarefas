package com.usuariotarefa.Usuario.domain;

import com.usuariotarefa.Tarefa.domain.Tarefa;
import com.usuariotarefa.Usuario.application.api.controller.requests.UsuarioAlteracaoRequest;
import com.usuariotarefa.Usuario.application.api.controller.requests.UsuarioRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "idUsuario", updatable = false, unique = true, nullable = false)
    private UUID idUsuario;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;

    @CreationTimestamp
    private LocalDateTime dataHoraDoCadastro ;
    private LocalDateTime dataHoraDaUltimaAlteracao ;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tarefa> tarefas = new ArrayList<>();


    public Usuario(UsuarioRequest usuarioRequest) {
        this.nome = usuarioRequest.getNome();
        this.email = usuarioRequest.getEmail();
        this.senha = usuarioRequest.getSenha();
        this.dataHoraDoCadastro = LocalDateTime.now();
    }

    public void altera(UsuarioAlteracaoRequest usuarioAlteracaoRequest) {
        this.nome = usuarioAlteracaoRequest.getNome();
        this.email = usuarioAlteracaoRequest.getEmail();
        this.senha = usuarioAlteracaoRequest.getSenha();
    }
}