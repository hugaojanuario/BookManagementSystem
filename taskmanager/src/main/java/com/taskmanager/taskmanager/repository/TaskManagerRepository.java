package com.taskmanager.taskmanager.repository;

import com.taskmanager.taskmanager.entity.TaskManager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskManagerRepository extends JpaRepository<TaskManager, Long> {
    
}
