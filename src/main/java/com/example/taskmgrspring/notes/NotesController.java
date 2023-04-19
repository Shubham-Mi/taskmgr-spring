package com.example.taskmgrspring.notes;

import com.example.taskmgrspring.notes.dtos.CreateNoteDto;
import com.example.taskmgrspring.notes.dtos.NoteResponseDto;
import com.example.taskmgrspring.notes.exceptions.NoteNotFoundException;
import com.example.taskmgrspring.tasks.exceptions.TaskNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;

@RestController
@RequestMapping("/tasks/{taskId}/notes")
public class NotesController {
    private final NotesService notesService;

    public NotesController(NotesService notesService) {
        this.notesService = notesService;
    }

    @PostMapping("")
    public ResponseEntity<NoteResponseDto> createNewNote(@PathVariable("taskId") Long taskId, @RequestBody CreateNoteDto note) {
        NoteResponseDto noteDto = notesService.createNode(taskId, note);
        return ResponseEntity.created(URI.create("/tasks" + taskId + "/")).body(noteDto);
    }

    @GetMapping("")
    public ArrayList<NoteEntity> getAllNotesByTaskId(@PathVariable("taskId") Long taskId) {
        return null;
    }

    @DeleteMapping("/{noteId}")
    public ArrayList<NoteEntity> deleteNoteByNoteId(@PathVariable("noteId") Long noteId) {
        return null;
    }

    @ExceptionHandler({IllegalArgumentException.class, TaskNotFoundException.class, NoteNotFoundException.class})
    public ResponseEntity<String> handleExceptions(Exception e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
