package com.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.model.Task;
import com.company.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService{

	@Autowired
	private TaskRepository repository;
	
	@Override
	public List<Task> getAllTask() {
		
		return repository.findAll();
	}

	@Override
	public Task getTaskByID(Long ID) {
		
		return repository.findById(ID).orElse(null);
	}

	@Override
	public Task saveTask(Task task) {
		
		return repository.save(task);
	}

	@Override
	public void deleteTask(Long id) {
		repository.deleteById(id);
		
	}

}
