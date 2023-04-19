package com.example.taskmgrspring.notes;

import com.example.taskmgrspring.notes.dtos.CreateNoteDto;
import com.example.taskmgrspring.notes.dtos.NoteResponseDto;
import com.example.taskmgrspring.notes.exceptions.NoteNotFoundException;
import com.example.taskmgrspring.tasks.TaskEntity;
import com.example.taskmgrspring.tasks.TasksService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotesService {
    private final NotesRepository notesRepository;
    private final TasksService tasksService;
    private final ModelMapper modelMapper;

    public NotesService(NotesRepository notesRepository, TasksService tasksService, ModelMapper modelMapper) {
        this.notesRepository = notesRepository;
        this.tasksService = tasksService;
        this.modelMapper = modelMapper;
    }

    public NoteResponseDto createNode(Long taskId, CreateNoteDto newNote) {
        NoteEntity note = modelMapper.map(newNote, NoteEntity.class);
        TaskEntity task = tasksService.getTaskEntity(taskId);
        note.setTask(task);
        NoteEntity savedNote = notesRepository.save(note);
        return modelMapper.map(savedNote, NoteResponseDto.class);
    }

    public List<NoteResponseDto> getAllTasks(Long taskId) {
        TaskEntity task = tasksService.getTaskEntity(taskId);
        List<NoteEntity> notes = task.getNotes();
        return notes.stream().map(note -> modelMapper.map(note, NoteResponseDto.class)).collect(Collectors.toList());
    }

    public void deleteNote(Long noteId) {
        notesRepository.deleteById(noteId);
    }
}
