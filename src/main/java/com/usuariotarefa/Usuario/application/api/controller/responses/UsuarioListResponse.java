package com.usuariotarefa.Usuario.application.api.controller.responses;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.usuariotarefa.Usuario.domain.Usuario;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@ToString
@Getter
@JsonPropertyOrder({ "idUsuario", "nome", "email", "dataHoraDoCadastro", "dataHoraDaUltimaAlteracao" })
public class UsuarioListResponse {
    private UUID idUsuario;
    private String nome;
    private String email;
    private LocalDateTime dataHoraDoCadastro ;
    private LocalDateTime dataHoraDaUltimaAlteracao ;

    public UsuarioListResponse(Usuario usuario) {
        this.idUsuario = usuario.getIdUsuario();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.dataHoraDoCadastro = usuario.getDataHoraDoCadastro();
        this.dataHoraDaUltimaAlteracao = usuario.getDataHoraDaUltimaAlteracao();
    }

    public static List<UsuarioListResponse> converte(List<Usuario> usuarios) {
        return usuarios.stream()
                .map(UsuarioListResponse::new)
                .collect(Collectors.toList());
    }
}
