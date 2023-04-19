package com.example.taskmgrspring.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TasksService {
    @Autowired
    private TasksRepository tasksRepository;

    public TaskEntity createTask(String title, String description, Date dueDate) {
        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setTitle(title);
        taskEntity.setDescription(description);
        taskEntity.setCompleted(false);
        taskEntity.setDueDate(dueDate);
        return tasksRepository.save(taskEntity);
    }
}
