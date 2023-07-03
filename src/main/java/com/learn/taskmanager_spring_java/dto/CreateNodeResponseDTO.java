package com.learn.taskmanager_spring_java.dto;

import com.learn.taskmanager_spring_java.entities.NoteEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateNodeResponseDTO {
    private Integer taskId;
    private NoteEntity note;
}
