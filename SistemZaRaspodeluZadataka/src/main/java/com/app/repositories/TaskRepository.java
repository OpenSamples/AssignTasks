package com.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Task;
import com.app.entities.User;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

	List<Task> findByUser(User user);

}
