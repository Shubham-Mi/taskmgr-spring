package com.example.taskmgrspring.tasks;

import com.example.taskmgrspring.tasks.dtos.CreateTaskDto;
import com.example.taskmgrspring.tasks.dtos.TaskResponseDto;
import com.example.taskmgrspring.tasks.exceptions.TaskNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TasksController {
    private final TasksService tasksService;

    public TasksController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @PostMapping("")
    public ResponseEntity<TaskResponseDto> createNewTask(@RequestBody CreateTaskDto createTask) {
        TaskResponseDto taskResponse = tasksService.createTask(createTask);
        return ResponseEntity.created(URI.create("/tasks/" + taskResponse.getId())).body(taskResponse);
    }

    @GetMapping("")
    public ResponseEntity<List<TaskResponseDto>> getAllTasks() {
        List<TaskResponseDto> tasks = tasksService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDto> getTaskById(@PathVariable("id") Long id) {
        TaskResponseDto task = tasksService.getTaskById(id);
        return ResponseEntity.ok(task);
    }
    
    @ExceptionHandler({IllegalArgumentException.class, TaskNotFoundException.class})
    public ResponseEntity<String> handleExceptions(Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
