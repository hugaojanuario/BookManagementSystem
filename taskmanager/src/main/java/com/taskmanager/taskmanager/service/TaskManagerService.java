package com.taskmanager.taskmanager.service;

import com.taskmanager.taskmanager.entity.TaskManager;
import com.taskmanager.taskmanager.repository.TaskManagerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class TaskManagerService {

    private final TaskManagerRepository taskManagerRepository;

    public TaskManagerService(TaskManagerRepository taskManagerRepository) {
        this.taskManagerRepository = taskManagerRepository;
    }

    public TaskManager criarTarefa (TaskManager taskManager){
        return taskManagerRepository.save(taskManager);
    }

    public List<TaskManager> listarTarefas(){
        return taskManagerRepository.findAll();
    }

    public Optional<TaskManager> buscarPorId(Long id){
        return taskManagerRepository.findById(id);
    }

    public void deletarTarefas(){
        taskManagerRepository.deleteAll();
    }

}
