package app.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.entities.Task;
import app.entities.User;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

	List<Task> findByUser(User user);

}
