package com.learn.taskmanager_spring_java.entities;

import lombok.Data;

@Data
public class NoteEntity {
    private int id;
    private String title;
    private String body;

}
