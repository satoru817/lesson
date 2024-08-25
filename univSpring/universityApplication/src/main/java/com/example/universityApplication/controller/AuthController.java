package com.example.universityApplication.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
	
	@GetMapping("/login")
	public String login() {
		return "admin/auth/login";
	}
}
