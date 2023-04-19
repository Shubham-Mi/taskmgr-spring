package com.example.taskmgrspring.tasks;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class TasksServiceTests {
    @Autowired
    private TasksService tasksService;

    @Test
    public void createTask() {
        TaskEntity task = tasksService.createTask("Task title", "Task description", new Date());
        System.out.println(task);
    }
}
