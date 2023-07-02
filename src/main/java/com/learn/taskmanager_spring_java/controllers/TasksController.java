package com.learn.taskmanager_spring_java.controllers;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.learn.taskmanager_spring_java.dto.CreateTaskDTO;
import com.learn.taskmanager_spring_java.entities.TaskEnitity;
import com.learn.taskmanager_spring_java.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TasksController {
    private final TaskService taskService;
    public TasksController(TaskService taskService){
        this.taskService = taskService;
    }
    @GetMapping("")
    public ResponseEntity<List<TaskEnitity>> getTasks(){
        var tasks = taskService.getTasks();

        return  ResponseEntity.ok(tasks);
    }
    @GetMapping("/{id}")
    public ResponseEntity<TaskEnitity> getTaskById(@PathVariable("id") Integer id){
        var task= taskService.getTaskById(id);
        if (task == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(task);
    }
    @PostMapping("")
    public ResponseEntity<TaskEnitity> addTask(@RequestBody CreateTaskDTO body){
        var task = taskService.addTask(body.getTitle(), body.getDescription(), body.getDeadline());

        return ResponseEntity.ok(task);
    }
}
