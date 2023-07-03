package com.learn.taskmanager_spring_java.service;

import com.learn.taskmanager_spring_java.entities.NoteEntity;
import com.learn.taskmanager_spring_java.entities.TaskEnitity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class NotesService {
    private TaskService taskService;
    private HashMap<Integer, TaskNotesHolder> taskNoteHolders = new HashMap<>();
    public NotesService(TaskService taskService){
        this.taskService = taskService;
    }
    class TaskNotesHolder{
        private int noteId = 1;
        private ArrayList<NoteEntity> notes = new ArrayList<>();
    }

    public List<NoteEntity> getNotesForTask(int taskId){
        TaskEnitity task = taskService.getTaskById(taskId);
        if(task == null){
            return null;
        }
        if (taskNoteHolders.get(taskId) == null){
            taskNoteHolders.put(taskId, new TaskNotesHolder());
        }
        return taskNoteHolders.get(taskId).notes ;
    }

    public NoteEntity addNoteForTask(int taskId, String title, String body){
        TaskEnitity task = taskService.getTaskById(taskId);
        if(task == null){
            return null;
        }
        if(taskNoteHolders.get(taskId) == null){
            taskNoteHolders.put(taskId, new TaskNotesHolder());
        }
        TaskNotesHolder taskNotesHolder = taskNoteHolders.get(taskId);
        NoteEntity note = new NoteEntity();
        note.setId(taskNotesHolder.noteId);
        note.setTitle(title);
        note.setBody(body);
        taskNotesHolder.notes.add(note);
        taskNotesHolder.noteId++;
        return note;

    }
}
