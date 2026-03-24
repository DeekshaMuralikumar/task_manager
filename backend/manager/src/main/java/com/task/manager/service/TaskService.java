package com.task.manager.service;

import java.util.List;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.task.manager.entity.Task;
import com.task.manager.repository.TaskRepository;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task task) {
        Task t = taskRepository.findById(id).orElseThrow();
        t.setTitle(task.getTitle());
        t.setCompleted(task.isCompleted());
        return taskRepository.save(t);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}