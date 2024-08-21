package com.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.service.UserService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/authenticate")
	public String authenticateUser(@RequestParam String name, @RequestParam String password, HttpServletRequest rq, Model m) {
		
		if(userService.getUser(name, password)) {
			rq.setAttribute("user", name);
			return "servicepage";
		}
		m.addAttribute("username", name);
		return "display";
		
	}

}
