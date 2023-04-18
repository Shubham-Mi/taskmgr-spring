package com.example.taskmgrspring.tasks;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Date;

@DataJpaTest
public class TasksServiceTests {
    @Autowired
    private TasksRepository tasksRepository;

    @Test
    public void createTask() {
        TasksService tasksService = new TasksService(tasksRepository);
        TaskEntity task = tasksService.createTask("Task title", "Task description", new Date());
        System.out.println(task);
    }
}
