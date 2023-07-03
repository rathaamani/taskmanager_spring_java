package com.learn.taskmanager_spring_java.controllers;


import com.learn.taskmanager_spring_java.dto.CreateNodeResponseDTO;
import com.learn.taskmanager_spring_java.dto.CreateNoteDTO;
import com.learn.taskmanager_spring_java.entities.NoteEntity;
import com.learn.taskmanager_spring_java.service.NotesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks/{taskId}/notes")
public class NotesController {

    private NotesService notesService;

    public NotesController( NotesService notesService){
        this.notesService = notesService;
    }
    @GetMapping("")
    public ResponseEntity<List<NoteEntity>> getNotes(@PathVariable("taskId") Integer taskId){
        var notes = notesService.getNotesForTask(taskId);

        return ResponseEntity.ok(notes);
    }
    @PostMapping("")
    public ResponseEntity<CreateNodeResponseDTO> addNote(@PathVariable("taskId") Integer taskId,@RequestBody CreateNoteDTO body){
        var note  = notesService.addNoteForTask(taskId, body.getTitle(), body.getBody());
        return  ResponseEntity.ok(new CreateNodeResponseDTO(taskId, note));
    }
}
