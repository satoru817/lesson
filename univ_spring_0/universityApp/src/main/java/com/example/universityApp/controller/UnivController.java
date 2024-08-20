package com.example.universityApp.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.universityApp.entity.Student;
import com.example.universityApp.repository.StudentRepository;

@Controller
@RequestMapping("/admin/univ")
public class UnivController {

	private final StudentRepository studentRepository;

	public UnivController(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@GetMapping("")
	public String index() {
		return "admin/univ/index";
	}

	@GetMapping("/students")
	public String students(Model model) {

		List<Student> students = studentRepository.findAll();

		model.addAttribute("students",students);

		return "admin/univ/students";
	}
	@GetMapping("/courses")
	public String courses() {
		return "admin/univ/courses";
	}
}
