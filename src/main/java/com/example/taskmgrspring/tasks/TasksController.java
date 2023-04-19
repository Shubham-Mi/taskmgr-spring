package com.example.taskmgrspring.tasks;

import com.example.taskmgrspring.tasks.dtos.CreateTaskDto;
import com.example.taskmgrspring.tasks.dtos.TaskResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;

@RestController
@RequestMapping("/tasks")
public class TasksController {
    private final TasksService tasksService;

    public TasksController(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @PostMapping("/")
    public ResponseEntity<TaskResponseDto> createNewTask(@RequestBody CreateTaskDto createTask) {
        TaskResponseDto taskResponse = tasksService.createTask(createTask);
        return ResponseEntity.created(URI.create("/tasks/" + taskResponse.getId())).body(taskResponse);
    }

    @GetMapping("/")
    public ArrayList<TaskEntity> getAllTasks() {
//        TODO: return a list of all tasks
        return null;
    }

    @GetMapping("/{id}")
    public TaskEntity getTaskById(@PathVariable("id") Long id) {
//        TODO: return task with given task id
        return null;
    }

    @PatchMapping("/{id}")
    public TaskEntity patchTask(@PathVariable("id") Long id) {
//        TODO: Patch the task with given task id
        return null;
    }

    @DeleteMapping("/{id}")
    public ArrayList<TaskEntity> deleteTask(@PathVariable("id") Long id) {
//        TODO: Delete the task with given task id
        return null;
    }
}
