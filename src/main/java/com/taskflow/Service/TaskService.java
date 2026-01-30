package com.taskflow.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taskflow.Dto.TaskRequest;
import com.taskflow.Entity.Task;
import com.taskflow.Repository.TaskRepository;
import com.taskflow.exception.ResourceNotFoundException;


@Service
public class TaskService  {

	 @Autowired
	    private TaskRepository taskRepository;

	
	    // Create Task
	    
	    
	    public Task createTask(TaskRequest request, Long userId) {

	        Task task = new Task();
	        task.setTitle(request.getTitle());
	        task.setDescription(request.getDescription());
	        task.setPriority(request.getPriority());
	        task.setStatus(request.getStatus());
	        task.setDueDate(request.getDueDate());
	        task.setCreated(LocalDateTime.now());
	        task.setUpdatedAt(LocalDateTime.now());

	        return taskRepository.save(task);
	    }

	
	    // Get All Tasks 
	   
	 
	    public List<Task> getAllTasks(
	            Long userId,
	            String status,
	            String priority
	          
	    ) {

//	        if (status != null && priority != null) {
//	            return taskRepository
//	                    .findByUserIdAndStatusAndPriority(userId, status, priority);
//	        }
//
//	        if (status != null) {
//	            return taskRepository
//	                    .findByUserIdAndStatus(userId, status);
//	        }
//
//	        if (priority != null) {
//	            return taskRepository
//	                    .findByUserIdAndPriority(userId, priority);
//	        }

	        return taskRepository.findAll();
	    }


	    // Get Task By ID
	  
	   
	    public Task getTaskById(Long taskId) {

	        Task task = taskRepository.findById(taskId)
	                .orElseThrow(() -> new RuntimeException("Task not found"));

	        if (!task.getId().equals(taskId)) {
	            throw new RuntimeException("You do not have permission to access this task");
	        }

	        return task;
	    }

	   
	    // Update Task
	 
	    
	    public Task updateTask(Long taskId, TaskRequest request, Long userId) {

	        Task task = getTaskById(taskId);

	        if (request.getTitle() != null) {
	            task.setTitle(request.getTitle());
	        }

	        if (request.getDescription() != null) {
	            task.setDescription(request.getDescription());
	        }

	        if (request.getPriority() != null) {
	            task.setPriority(request.getPriority());
	        }

	        if (request.getStatus() != null) {
	            task.setStatus(request.getStatus());
	        }

	        if (request.getDueDate() != null) {
	            task.setDueDate(request.getDueDate());
	        }

	        task.setUpdatedAt(LocalDateTime.now());

	        return taskRepository.save(task);
	    }

	   
	    // Delete Task
	   
	    public void deleteTask(Long taskId, Long userId) {

	        Task task = getTaskById(taskId);
	        taskRepository.delete(task);
	        
	        Task task1 = taskRepository.findById(taskId)
	                .orElseThrow(() -> new ResourceNotFoundException("Task not found with id " + taskId));

	    }
	}
