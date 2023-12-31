package com.learn.taskmanager_spring_java.entities;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class TaskEnitity {
    private int id;
    private String title;
    private String description;
    private Date deadline;
    private boolean completed;

}
