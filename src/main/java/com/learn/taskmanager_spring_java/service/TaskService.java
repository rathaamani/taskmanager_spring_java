package com.learn.taskmanager_spring_java.service;

import com.learn.taskmanager_spring_java.entities.TaskEnitity;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Service
public class TaskService {
    private ArrayList<TaskEnitity> tasks = new ArrayList<>();
    private int taskId= 1;
    private SimpleDateFormat deadlineFormatter = new SimpleDateFormat("yyyy-MM-dd");

    public TaskEnitity addTask(String  title, String description, String deadline) throws ParseException {
        TaskEnitity task = new TaskEnitity();
        task.setId(taskId);
        task.setTitle(title);
        task.setDescription(description);
       task.setDeadline(deadlineFormatter.parse(deadline)); // todo: validate that format yyyy-mm-dd
        task.setCompleted(false);
        tasks.add(task);
        taskId++;
        return task;
    }
     public ArrayList<TaskEnitity> getTasks(){
        return tasks;
    }
    public TaskEnitity getTaskById(int id){
     //    tasks.stream().findAny().filter(task -> task.getId() == id).orElse(null);
        for(TaskEnitity task : tasks){
            if(task.getId() == id){
                return  task;
            }
        }
        return null;
    }
    public TaskEnitity updateTask(int id, String description, String deadline, Boolean completed) throws ParseException{
       TaskEnitity task = getTaskById(id);
       if(task == null){
           return null;
       }
       if(description != null){
           task.setDescription(description);
       }
       if(deadline != null){
           task.setDeadline(deadlineFormatter.parse(deadline));
       }
       if(completed != null ){
           task.setCompleted(completed);
       }

       return task;
    }
}
