package com.example.taskmgrspring.tasks;

import com.example.taskmgrspring.tasks.dtos.CreateTaskDto;
import com.example.taskmgrspring.tasks.dtos.TaskResponseDto;
import com.example.taskmgrspring.tasks.exceptions.TaskNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TasksService {
    private final TasksRepository tasksRepository;
    private final ModelMapper modelMapper;

    public TasksService(TasksRepository tasksRepository, ModelMapper modelMapper) {
        this.tasksRepository = tasksRepository;
        this.modelMapper = modelMapper;
    }

    public TaskEntity getTaskEntity(Long id) {
        return tasksRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
    }

    public TaskResponseDto createTask(CreateTaskDto newTask) {
//        Data validation
        if (newTask.getDueDate().before(new Date())) {
            throw new IllegalArgumentException("Due date cannot be in the past");
        }
        TaskEntity task = modelMapper.map(newTask, TaskEntity.class);
        task.setCompleted(false);
        TaskEntity savedTask = tasksRepository.save(task);
        return modelMapper.map(savedTask, TaskResponseDto.class);
    }

    public TaskResponseDto getTaskById(Long id) {
        TaskEntity task = tasksRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
        return modelMapper.map(task, TaskResponseDto.class);
    }

    public List<TaskResponseDto> getAllTasks() {
        List<TaskEntity> tasks = tasksRepository.findAll();
        return tasks.stream().map(task -> modelMapper.map(task, TaskResponseDto.class)).collect(Collectors.toList());
    }

    public void deleteTask(Long id) {
        TaskEntity task = tasksRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
        tasksRepository.delete(task);
    }

    public TaskResponseDto patchTask(Long id, CreateTaskDto updatedTask) {
        TaskEntity task = tasksRepository.findById(id).orElseThrow(() -> new TaskNotFoundException(id));
        if (updatedTask.getTitle() != null) {
            task.setTitle(updatedTask.getTitle());
        }
        if (updatedTask.getDescription() != null) {
            task.setDescription(updatedTask.getDescription());
        }
        if (updatedTask.getDueDate() != null) {
            task.setDueDate(updatedTask.getDueDate());
        }
        tasksRepository.save(task);
        return modelMapper.map(task, TaskResponseDto.class);
    }
}
