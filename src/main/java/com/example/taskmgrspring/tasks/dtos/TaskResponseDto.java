package com.example.taskmgrspring.tasks.dtos;

import com.example.taskmgrspring.notes.dtos.NoteResponseDto;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class TaskResponseDto {
    private Long id;
    private String title;
    private String description;
    private Boolean completed;
    private Date dueDate;
    private List<NoteResponseDto> notes;
}
