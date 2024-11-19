package com.tasks.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.tasks.entity.TasksEntity;
import com.tasks.entity.TasksEntity.Status;
import com.tasks.repository.TasksManagerRepository;
import com.tasks.service.TasksManagerServiceDaoImpl;


public class TaskServiceTest {


    @Mock
    private TasksManagerRepository managerRepository;

    @InjectMocks
    private TasksManagerServiceDaoImpl serviceDaoImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateTask() {
        // Arrange: Mock input and expected output
        TasksEntity inputTask = new TasksEntity();
        inputTask.setTitle("Test Task");
        inputTask.setDescription("Description of the test task");
        inputTask.setDueDate(LocalDate.of(2024, 11, 20));
        inputTask.setStatus(Status.PENDING);

        TasksEntity savedTask = new TasksEntity();
        savedTask.setId(1L);
        savedTask.setTitle("Test Task");
        savedTask.setDescription("Description of the test task");
        savedTask.setDueDate(LocalDate.of(2024, 11, 20));
        savedTask.setStatus(Status.PENDING);

        when(managerRepository.save(inputTask)).thenReturn(savedTask);

        // Act: Call the method under test
        TasksEntity result = serviceDaoImpl.saveTask(inputTask);

        // Assert: Verify the result and interactions
        assertNotNull(result);
        assertEquals(savedTask.getId(), result.getId());
        assertEquals(savedTask.getTitle(), result.getTitle());
        assertEquals(savedTask.getDescription(), result.getDescription());
        assertEquals(savedTask.getDueDate(), result.getDueDate());
        assertEquals(savedTask.getStatus(), result.getStatus());

        verify(managerRepository, times(1)).save(inputTask);
    }
    
}