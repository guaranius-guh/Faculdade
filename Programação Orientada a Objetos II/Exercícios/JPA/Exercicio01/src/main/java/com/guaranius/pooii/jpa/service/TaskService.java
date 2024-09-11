package com.guaranius.pooii.jpa.service;

import com.guaranius.pooii.jpa.entity.Task;
import com.guaranius.pooii.jpa.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {
        if (task.getTitle().length() < 5) {
            throw new IllegalArgumentException("The task title must contain at least 5 characters.");
        }
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public Task updateTask(Task task) {
        if (task.isCompleted()) {
            throw new IllegalArgumentException("Completed tasks cannot be modified.");
        }
        return taskRepository.save(task);
    }

    public void deleteTaskById(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Task not found"));
        if (task.isCompleted()) {
            throw new IllegalArgumentException("Completed tasks cannot be deleted.");
        }
        taskRepository.delete(task);
    }

    public List<Task> getUncompletedTasks() {
        return taskRepository.findByCompleted(false);
    }

    public List<Task> getCompletedTasks() {
        return taskRepository.findByCompleted(true);
    }

    public List<Task> getOverdueTasks() {
        return taskRepository.findByDueDateBeforeAndCompletedFalse(LocalDate.now());
    }

    public List<Task> getUncompletedTasksBetweenDates(LocalDate startDate, LocalDate endDate) {
        return taskRepository.findByCompletedFalseAndDueDateBetween(startDate, endDate);
    }

    public Task completeTask(Long id) {
        Task task = taskRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Task not found"));
        task.setCompleted(true);
        task.setCompletionDate(LocalDate.now());
        return taskRepository.save(task);
    }
}
