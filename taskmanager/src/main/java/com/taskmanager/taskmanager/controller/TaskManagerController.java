package com.taskmanager.taskmanager.controller;


import com.taskmanager.taskmanager.entity.TaskManager;
import com.taskmanager.taskmanager.service.TaskManagerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TaskManagerController {

    private final TaskManagerService taskManagerService;

    public TaskManagerController(TaskManagerService taskManagerService) {
        this.taskManagerService = taskManagerService;
    }

    @GetMapping
    public List <TaskManager> listarTarefas(){
        return taskManagerService.listarTarefas();
    }

    @PostMapping
    public TaskManager criarTarefa(@RequestBody TaskManager taskManager) {
        return taskManagerService.criarTarefa(taskManager);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskManager> buscarPorId(@PathVariable Long id) {
        return taskManagerService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping()
    public ResponseEntity<Void> deletarTarefa() {
        taskManagerService.deletarTarefas();
        return ResponseEntity.noContent().build();

    }
}
