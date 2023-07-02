package com.learn.taskmanager_spring_java.service;

import com.learn.taskmanager_spring_java.entities.TaskEnitity;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class TaskService {
    private ArrayList<TaskEnitity> tasks = new ArrayList<>();
    private int taskId= 1;

    public TaskEnitity addTask(String  title, String description, String deadline){
        TaskEnitity task = new TaskEnitity();
        task.setId(taskId);
        task.setTitle(title);
        task.setDescription(description);
    //    task.setDeadline(new Date(deadline)); // todo: validate that format yyyy-mm-dd
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
}
