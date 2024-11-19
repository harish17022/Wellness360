package com.tasks.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.tasks.entity.TasksEntity;
import com.tasks.service.TasksManagerServiceDaoImpl;

@RestController
@RequestMapping("/api") 	// Base URL for all API endpoints in this controller
public class TasksManagerController {
	
	@Autowired
	private TasksManagerServiceDaoImpl serviceDaoImpl;				 // Service layer dependency for task management logic.
	
	
	// Handles HTTP GET requests to fetch all tasks.
	
	@GetMapping("/tasks")
	public List<TasksEntity> getTasks(){
		return serviceDaoImpl.getAllTasks();
		
	}
	
	
	// Handles HTTP GET requests to fetch a specific task by its ID.
	
	@GetMapping("/tasks/{taskId}")
	public Optional<TasksEntity> getTask(@PathVariable int taskId) {
		return serviceDaoImpl.getTaskById(taskId);
		
	}
	
	
	//Handles HTTP POST requests to add a new task.
	
	
	@PostMapping("/tasks")
	public TasksEntity addTask(@RequestBody TasksEntity entity) {
		return serviceDaoImpl.saveTask(entity);
		
	}
	
	//Handles HTTP PUT requests to update an existing task.
	
	@PutMapping("/tasks/{taskId}")
	public TasksEntity updateTask(@PathVariable int taskId ,@RequestBody TasksEntity entity) {
		return serviceDaoImpl.updateTask(taskId, entity);
		
	}
	
	
	//Handles HTTP DELETE requests to delete a specific task by its ID.
	
	@DeleteMapping("/tasks/{taskId}")
	public String deleteTask(@PathVariable int taskId) {
		Optional<TasksEntity> taskById = serviceDaoImpl.getTaskById(taskId);
		if(taskById == null) {
			throw new RuntimeException("Task Id not found: "+ taskId);
		}
		else {
			serviceDaoImpl.deleteTask(taskId);
		}
		return "Task with Id: "+taskId+" Deleted";
		
	}
	
	// PUT to mark a task as completed
    @PutMapping("/{taskId}/complete")
    @ResponseStatus(HttpStatus.OK)  	// Response status will be 200 OK if the task is marked as complete successfully
    public TasksEntity markTaskAsComplete(@PathVariable int taskId) {
        // Directly call the service method to mark the task as complete.
        return serviceDaoImpl.markTaskAsComplete(taskId);
    }

}
