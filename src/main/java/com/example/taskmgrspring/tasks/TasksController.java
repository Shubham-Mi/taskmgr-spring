package com.example.taskmgrspring.tasks;

import com.example.taskmgrspring.common.ErrorResponseDto;
import com.example.taskmgrspring.tasks.dtos.CreateTaskDto;
import com.example.taskmgrspring.tasks.dtos.TaskResponseDto;
import com.example.taskmgrspring.tasks.exceptions.TaskNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
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

    @PatchMapping("/{id}")
    public ResponseEntity<TaskResponseDto> patchTask(@PathVariable("id") Long id, @RequestBody CreateTaskDto updatedTask) {
        TaskResponseDto taskResponse = tasksService.patchTask(id, updatedTask);
        return ResponseEntity.ok(taskResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable("id") Long id) {
        tasksService.deleteTask(id);
        return ResponseEntity.ok("Deleted successfully");
    }

    @ExceptionHandler({IllegalArgumentException.class, TaskNotFoundException.class})
    public ResponseEntity<ErrorResponseDto> handleExceptions(Exception e) {
        if (e instanceof TaskNotFoundException) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponseDto(e.getMessage()));
        }
        return ResponseEntity.badRequest().body(new ErrorResponseDto(e.getMessage()));
    }
}
