package com.example.taskmgrspring.notes;

import com.example.taskmgrspring.tasks.TaskEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "notes")
public class NoteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    //    @Column(nullable = false)
    private String title;
    private String description;
    @ManyToOne(targetEntity = TaskEntity.class)
    private TaskEntity task;
}
