package com.proyect.taskManager.controller;

// Recibe las peticiones HTTP, interactúa con el Modelo (a través del TaskService) y devuelve la respuesta. No contiene lógica de negocio.

import com.proyect.taskManager.model.Task;
import com.proyect.taskManager.repository.TaskRepository;
import com.proyect.taskManager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "http://localhost:5000") // Asegúrate de que este sea el puerto de tu Flutter app / Permite peticiones desde tu frontend Flutter (o el puerto que uses)
public class TaskController {


    @Autowired
    private  TaskService taskService; //inyeccion de dependencia del repositorio

    @GetMapping
    public List<Task> getAllTask(){
        return taskService.getAllTask();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id){
        Optional<Task> task = taskService.getTaskById(id);
        return task.map(ResponseEntity::ok)//200
                .orElseGet(() -> ResponseEntity.notFound().build());//440
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        Task savedTask = taskService.createTask(task);
        return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id,@RequestBody Task taskDetails){
        Optional<Task> taskUpdate = taskService.updateTask(id,taskDetails);
        return taskUpdate.map(ResponseEntity::ok)//200 exito
                .orElseGet(()->ResponseEntity.notFound().build());//440 no found
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Task> deleteTask(@PathVariable Long id){
        if(taskService.deleteTask(id)){
            return ResponseEntity.noContent().build();//codigo de estado 200
        }else{
            return ResponseEntity.notFound().build();//codigo de estado 440
        }
    }



}
