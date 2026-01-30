package com.taskflow.Dto;

import java.time.LocalDate;

import com.taskflow.Entity.Priority;
import com.taskflow.Entity.Status;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskResponse {
    private Long id;
    private String title;
    private Priority priority;
    private Status status;
    private LocalDate dueDate;
    
    
    
    
    
}

