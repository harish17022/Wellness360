package com.tasks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tasks.entity.TasksEntity;

@Repository
public interface TasksManagerRepository extends JpaRepository<TasksEntity, Integer>{

}
