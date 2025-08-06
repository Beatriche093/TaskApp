package com.proyect.taskManager.service;

//Aqui se encapsula la logica de negocio real.

import com.proyect.taskManager.model.Task;
import com.proyect.taskManager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTask(){

        return taskRepository.findAll();
    }

    //Optional<T> es una clase de contenedor que puede o no contener un valor no nulo.
    public Optional<Task> getTaskById(Long id){

        return taskRepository.findById(id);
    }

    public Task createTask(Task task){
        //aqui podemos añadir la logica de validacion
        return taskRepository.save(task);
    }


    //refactorizar o entender (tengo la sensación que hay mucha cosa que se puede quitar)
    public Optional<Task> updateTask(Long id, Task taskDetails){
        Optional<Task> taskOptional = taskRepository.findById(id);
        if(taskOptional.isPresent()){
            Task existingTask = taskOptional.get();
            existingTask.setTittle(taskDetails.getTittle());
            existingTask.setDescription(taskDetails.getDescription());
            existingTask.setCompleted(taskDetails.isCompleted());

            return Optional.of(taskRepository.save(existingTask));//devuelve el objeto con los datos nuevos

        }else{
            return Optional.empty();//si no lo encuentra devuelve uno vacio
        }
    }

    public boolean deleteTask(Long id){
        if(taskRepository.existsById(id)){
            taskRepository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

}
