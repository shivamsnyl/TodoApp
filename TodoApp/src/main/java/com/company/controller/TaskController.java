package com.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.company.model.Task;
import com.company.service.TaskService;

@Controller
public class TaskController {
	
	@Autowired
	private TaskService service;
	
	
	@GetMapping("/")
	public String login() {
		return "index";
	}
	
	@GetMapping("/getAllTask")
	public String getAllTasks(Model m) {
		
		m.addAttribute("tasks",service.getAllTask());
		return "home";
	}  
	
	@GetMapping("/{id}")
	public String getById(@PathVariable Long id, Model m) {
		m.addAttribute("tasks",service.getTaskByID(id));
		return "home";
	} 
	
	@GetMapping("/add")
	public String addTask(Model m) {
		
		m.addAttribute("task",new Task());
		System.out.println("Add Task");
		return "add";
	}
	
	@PostMapping("/save")
	public String saveTask(@ModelAttribute Task task) {
		
		service.saveTask(task);
		return "redirect:/getAllTask";
	}
	
	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable Long id) {
		service.deleteTask(id);
		return "redirect:/getAllTask";
	}

}
