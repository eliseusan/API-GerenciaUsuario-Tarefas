package com.usuariotarefa.Tarefa.infra;

import com.usuariotarefa.Tarefa.domain.Tarefa;
import com.usuariotarefa.Usuario.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TarefaSpringDataJPARepository extends JpaRepository<Tarefa, UUID> {
    List<Tarefa> findByUsuario(Usuario usuario);
}

