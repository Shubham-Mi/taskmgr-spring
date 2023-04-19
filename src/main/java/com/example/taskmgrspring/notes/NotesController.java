package com.example.taskmgrspring.notes;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/tasks/{taskId}/notes")
public class NotesController {
    @GetMapping("/")
    public ArrayList<NoteEntity> getAllNotesByTaskId(@PathVariable("taskId") Long taskId) {
        return null;
    }

    @PostMapping("")
    public ArrayList<NoteEntity> createNewNote(@PathVariable("taskId") Long taskId) {
        return null;
    }

    @DeleteMapping("/{noteId}")
    public ArrayList<NoteEntity> deleteNoteByNoteId(@PathVariable("noteId") Long noteId) {
        return null;
    }
}
