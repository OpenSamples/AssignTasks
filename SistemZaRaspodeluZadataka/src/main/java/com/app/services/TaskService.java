package com.app.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entities.Task;
import com.app.entities.User;
import com.app.repositories.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;

	public Task findTaskById(Long id) {
		return taskRepository.findById(id)
				.orElseThrow(() -> new NoSuchElementException("Ne posotji task sa ID"));		
	}
	
	public void addTask(Task task, User user) {
		task.setUser(user);
		taskRepository.save(task);
	}

	public List<Task> findUserTask(User user) {
		return taskRepository.findByUser(user);
	}
	
	public List<Task> findAllTasksByUser(String userEmail) {
		return taskRepository.findAllTasksByUser(userEmail);
	}
	
	

	public boolean updateTask(Task task) {
		Task existingTask = taskRepository.getOne(task.getId());
		if (existingTask != null) {
			taskRepository.save(task);
			return true;
		} else {
			return false;
		}
	}

	public boolean deleteTask(Task task) {
		Task existingTask = taskRepository.getOne(task.getId());
		if (existingTask != null) {
			taskRepository.delete(task);
			return true;
		} else {
			return false;
		}
	}
}
