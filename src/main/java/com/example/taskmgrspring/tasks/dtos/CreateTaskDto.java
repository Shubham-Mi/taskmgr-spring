package com.example.taskmgrspring.tasks.dtos;

import lombok.Data;
import lombok.NonNull;

import java.util.Date;

@Data
public class CreateTaskDto {
    String title;
    String description;
    Date dueDate;
}
