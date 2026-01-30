package com.taskflow.Controller;


import com.taskflow.Dto.TaskRequest;
import com.taskflow.Entity.Task;
import com.taskflow.Service.TaskService;


import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {


    @Autowired
    private TaskService taskService;;


    
    //  Create New Task
    
    @PostMapping
    public ResponseEntity<?> createTask(@Valid @RequestBody TaskRequest request) {

        Long loggedInUserId = 1L; // replace with JWT later

        Task task = taskService.createTask(request, loggedInUserId);

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Task created successfully");
        response.put("data", task);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

   
    // Get All Tasks 

    @GetMapping
    public ResponseEntity<?> getAllTasks(
            @RequestParam(required = false) String status,
            @RequestParam(required = false) String priority,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int limit
    ) {

        Long loggedInUserId = 1L;

        List<Task> tasks = taskService.getAllTasks(
                loggedInUserId,
                status,
                priority
          
        );

  

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
response.put("data", tasks);

        return ResponseEntity.ok(response);
    }


    // Get Single Task
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getTaskById(@PathVariable Long id) {

    

        Task task = taskService.getTaskById(id);

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("data", task);

        return ResponseEntity.ok(response);
    }

  
    //  Update Task
    
    @PutMapping("/{id}")
    public ResponseEntity<?> updateTask(
            @PathVariable Long id,
            @Valid @RequestBody TaskRequest request
    ) {

        Long loggedInUserId = 1L;

        Task updatedTask = taskService.updateTask(id, request, loggedInUserId);

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Task updated successfully");
        response.put("data", updatedTask);

        return ResponseEntity.ok(response);
    }


    // Delete Task

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable Long id) {

        Long loggedInUserId = 1L;

        taskService.deleteTask(id, loggedInUserId);

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Task deleted successfully");

        return ResponseEntity.ok(response);
    }
}
