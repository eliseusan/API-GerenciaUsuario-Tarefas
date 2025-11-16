package com.usuariotarefa.Usuario.application.api.controller.responses;

import com.usuariotarefa.Usuario.domain.Usuario;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@ToString
public class UsuarioDetalhadoListResponse {
    private UUID idUsuario;
    private String nome;
    private String email;
    private String senha;
    private LocalDateTime dataHoraDoCadastro ;
    private LocalDateTime dataHoraDaUltimaAlteracao ;

    public UsuarioDetalhadoListResponse(Usuario usuario) {
        this.idUsuario = usuario.getIdUsuario();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
        this.dataHoraDoCadastro = usuario.getDataHoraDoCadastro();
        this.dataHoraDaUltimaAlteracao = usuario.getDataHoraDaUltimaAlteracao();
    }
}
