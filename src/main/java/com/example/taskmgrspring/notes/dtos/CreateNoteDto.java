package com.example.taskmgrspring.notes.dtos;

import lombok.Data;
import lombok.NonNull;

@Data
public class CreateNoteDto {
    String title;
    String description;
}
