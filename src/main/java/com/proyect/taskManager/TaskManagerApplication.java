package com.proyect.taskManager;

import com.proyect.taskManager.controller.TaskController;
import com.proyect.taskManager.model.Task;
import com.proyect.taskManager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class TaskManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskManagerApplication.class, args);

	}



}
