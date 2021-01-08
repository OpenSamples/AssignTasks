package com.app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.app.entities.Task;
import com.app.entities.User;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

	List<Task> findByUser(User user);
	
	// JPQL inside of @Query annotation  
	@Query("SELECT t FROM Task t LEFT JOIN FETCH t.user u WHERE u.email LIKE :userEmail ORDER BY t.date ASC")
	List<Task> findAllTasksByUser(String userEmail);

}
