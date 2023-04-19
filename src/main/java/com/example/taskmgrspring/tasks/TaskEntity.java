package com.example.taskmgrspring.tasks;

import com.example.taskmgrspring.notes.NoteEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "tasks")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    private String title;
    private String  description;
    @Column(nullable = false)
    private boolean completed;
    @Column(nullable = false)
    private Date dueDate;
    @OneToMany(targetEntity = NoteEntity.class, cascade = CascadeType.ALL, mappedBy = "task")
    private List<NoteEntity> notes;
}
