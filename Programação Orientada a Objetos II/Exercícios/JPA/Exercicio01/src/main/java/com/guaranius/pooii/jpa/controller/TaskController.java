package com.guaranius.pooii.jpa.controller;

import com.guaranius.pooii.jpa.entity.Task;
import com.guaranius.pooii.jpa.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<?> createTask(@RequestBody Task task) {
        try {
            task = taskService.createTask(task);
            return new ResponseEntity<>(task, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task updatedTask) {
        Task existingTask = taskService.getTaskById(id)
                .orElseThrow(() -> new IllegalArgumentException("Task not found"));
        if (existingTask.isCompleted()) {
            throw new IllegalArgumentException("Completed tasks cannot be modified.");
        }
        updatedTask.setId(id); // Ensure the correct ID is set
        return ResponseEntity.ok(taskService.updateTask(updatedTask));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTaskById(@PathVariable Long id) {
        taskService.deleteTaskById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/uncompleted")
    public List<Task> getUncompletedTasks() {
        return taskService.getUncompletedTasks();
    }

    @GetMapping("/completed")
    public List<Task> getCompletedTasks() {
        return taskService.getCompletedTasks();
    }

    @GetMapping("/overdue")
    public List<Task> getOverdueTasks() {
        return taskService.getOverdueTasks();
    }

    @GetMapping("/uncompleted-between-dates")
    public List<Task> getUncompletedTasksBetweenDates(@RequestParam("start") LocalDate startDate,
                                                      @RequestParam("end") LocalDate endDate) {
        return taskService.getUncompletedTasksBetweenDates(startDate, endDate);
    }

    @PutMapping("/complete/{id}")
    public ResponseEntity<Task> completeTask(@PathVariable Long id) {
        return ResponseEntity.ok(taskService.completeTask(id));
    }
}
