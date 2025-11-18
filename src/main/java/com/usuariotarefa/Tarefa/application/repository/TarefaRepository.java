package com.usuariotarefa.Tarefa.application.repository;

import com.usuariotarefa.Tarefa.domain.Tarefa;
import com.usuariotarefa.Usuario.domain.Usuario;

import java.util.List;

public interface TarefaRepository {
    Tarefa salvaTarefa(Tarefa tarefa);

    List<Tarefa> buscaTodasTarefas();
}
