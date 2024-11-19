package com.tasks.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import com.tasks.entity.TasksEntity;
import com.tasks.entity.TasksEntity.Status;
import com.tasks.repository.TasksManagerRepository;
@Service
public class TasksManagerServiceDaoImpl implements TasksManagerServiceDao{

	@Autowired
	private TasksManagerRepository tasksRepo;

	
	//Returns a list of all tasks from the database.
	
	@Override
	public List<TasksEntity> getAllTasks() {
		return tasksRepo.findAll();
	}

	// Fetches a task by its ID.
	@Override
	public Optional<TasksEntity> getTaskById(int id) {
		if(tasksRepo.findById(id).isPresent()) {			// check Task id is present or not
			return tasksRepo.findById(id);
		}
		else {
			throw new RuntimeException(id+" is not Found");
		}
	}

	
	//Saves a new task to the database.
	@Override
	public TasksEntity saveTask(TasksEntity task) {
		return tasksRepo.save(task);
	}

	//Updates an existing task by ID.
	@Override
	public TasksEntity updateTask(int id, TasksEntity task) {
		Optional<TasksEntity> byId = tasksRepo.findById(id);		// fetch the Task id.
		if(byId.isPresent()) {									// check Task is Present or not if present set the data	
			TasksEntity tasks = byId.get();
			tasks.setTitle(task.getTitle());
			tasks.setDescription(task.getDescription());
			tasks.setStatus(task.getStatus());
			tasks.setDueDate(task.getDueDate());
			return tasksRepo.save(tasks);
			
		}
		else {
			throw new RuntimeException("No Task found With Id= "+id);
		}
	}
	
	//Deletes a task by its ID.

	@Override
	public void deleteTask(int id) {
		Optional<TasksEntity> findById = tasksRepo.findById(id);		//// fetch the Task id.
		if(findById != null) {
			tasksRepo.deleteById(id);;
		}
		else{
			throw new RuntimeException("No Task found With Id= "+id);
		}
		
	}
	
	// Changes the status of a task to "COMPLETED".
	
	@Override
	public TasksEntity markTaskAsComplete(int id) {
		Optional<TasksEntity> byId = tasksRepo.findById(id);
		if(byId.isPresent()) {
			TasksEntity tasksEntity = byId.get();
			tasksEntity.setStatus(Status.COMPLETED);
			return tasksRepo.save(tasksEntity);
		}
		
		else {
			throw new RuntimeException("No Task found With Id= "+id);
		}
	}
	
	

}
