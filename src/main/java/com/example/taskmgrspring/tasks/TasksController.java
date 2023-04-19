package com.example.taskmgrspring.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
@RequestMapping("/tasks")
public class TasksController {
    @Autowired private TasksService tasksService;

    @PostMapping("/")
    public TaskEntity createNewTask(@RequestBody TaskEntity taskEntity) {
        return null;
    }
    @GetMapping("/")
    public ArrayList<TaskEntity> getAllTasks() {
        return null;
    }

    @GetMapping("/{id}")
    public TaskEntity getTaskById(@PathVariable("id") Long id) {
        return null;
    }

    @PatchMapping("/{id}")
    public TaskEntity patchTask(@PathVariable("id")  Long id) {
        return null;
    }

    @DeleteMapping("/{id}")
    public  ArrayList<TaskEntity> deleteTask(@PathVariable("id") Long id) {
        return null;
    }
}
