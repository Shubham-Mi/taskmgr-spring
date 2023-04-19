package com.example.taskmgrspring.tasks.dtos;

import lombok.Data;
import lombok.NonNull;

import java.util.Date;

@Data
public class CreateTaskDto {
    @NonNull String title;
    String description;
    @NonNull Date dueDate;
}
