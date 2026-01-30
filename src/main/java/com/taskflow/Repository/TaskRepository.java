package com.taskflow.Repository;

import java.util.Optional;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.taskflow.Entity.Task;
import com.taskflow.Entity.User;



@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

	Optional<Task> findByUser(User user);

	Optional<Task> findByUserIdAndStatusAndPriority(Long userId, String status, String priority);

	Optional<Task> findByUserIdAndStatus(Long userId, String status);

	Optional<Task> findByUserIdAndPriority(Long userId, String priority);
}
