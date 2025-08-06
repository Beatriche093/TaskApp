package com.proyect.taskManager.repository;
//Este repositorio va a proporcinar los metodos para intereactuar directamente con la bbdd. Es parte del Modelo pq gestiona
// la persistencia del dato.

import com.proyect.taskManager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}

