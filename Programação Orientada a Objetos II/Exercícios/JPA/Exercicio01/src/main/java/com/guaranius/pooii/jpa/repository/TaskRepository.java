package com.guaranius.pooii.jpa.repository;

import com.guaranius.pooii.jpa.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByCompleted(boolean completed);
    List<Task> findByDueDateBeforeAndCompletedFalse(LocalDate today);
    List<Task> findByCompletedFalseAndDueDateBetween(LocalDate startDate, LocalDate endDate);
}
