package com.usuariotarefa.Tarefa.application.repository;

import com.usuariotarefa.Tarefa.domain.Tarefa;
import com.usuariotarefa.Usuario.domain.Usuario;

import java.util.List;
import java.util.UUID;

public interface TarefaRepository {
    Tarefa salvaTarefa(Tarefa tarefa);

    List<Tarefa> buscaTodasTarefas();

    List<Tarefa> buscaTodasTarefasDoUsuario(Usuario usuario);

    Tarefa buscaTarefaPorId(UUID idTarefa);

    void deletaTarefa(Tarefa tarefa);
}
