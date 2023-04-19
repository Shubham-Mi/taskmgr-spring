package com.example.taskmgrspring.notes.exceptions;

public class NoteNotFoundException extends IllegalArgumentException {
    public NoteNotFoundException(Long id) {
        super("Note with id: " + id + " not found");
    }
}
