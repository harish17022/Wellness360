package com.tasks.service;

import java.util.List;
import java.util.Optional;


import com.tasks.entity.TasksEntity;

public interface TasksManagerServiceDao {
	List<TasksEntity> getAllTasks();

    Optional<TasksEntity> getTaskById(int id);

    TasksEntity saveTask(TasksEntity task);

    TasksEntity updateTask(int id, TasksEntity task);

    void deleteTask(int id);

    TasksEntity markTaskAsComplete(int id);
}
