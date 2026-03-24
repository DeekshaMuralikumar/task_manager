package com.task.manager;

import com.task.manager.entity.Task;
import com.task.manager.repository.TaskRepository;
import com.task.manager.service.TaskService;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {

    TaskRepository taskRepository = mock(TaskRepository.class);
    TaskService taskService = new TaskService(taskRepository);

    @Test
    void testAddTask() {

        Task task = new Task(1L, "Test Task", false);
        when(taskRepository.save(task)).thenReturn(task);

        Task saved = taskService.addTask(task);

        assertEquals("Test Task", saved.getTitle());
    }
}
