package com.company.service;

import java.util.List;

import com.company.model.Task;

public interface TaskService {
	
	List<Task> getAllTask();
	Task getTaskByID(Long ID);
	Task saveTask(Task task);
	void deleteTask(Long id);

}
