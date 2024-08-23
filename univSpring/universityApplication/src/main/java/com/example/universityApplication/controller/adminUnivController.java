package com.example.universityApplication.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.universityApplication.entity.Attendance;
import com.example.universityApplication.entity.Course;
import com.example.universityApplication.entity.Student;
import com.example.universityApplication.repository.AttendanceRepository;
import com.example.universityApplication.repository.CourseRepository;
import com.example.universityApplication.repository.StudentRepository;
import com.example.universityApplication.repository.TeacherRepository;

@Controller
@RequestMapping("admin/univ")
public class adminUnivController {
	
	private final StudentRepository studentRepository;
	private final CourseRepository courseRepository;
	private final AttendanceRepository attendanceRepository;
	
	public adminUnivController(StudentRepository studentRepository,TeacherRepository teacherRepository, CourseRepository courseRepository,AttendanceRepository attendanceRepository) {
		this.studentRepository = studentRepository;
		this.attendanceRepository = attendanceRepository;
		this.courseRepository = courseRepository;
	}
	
	@GetMapping
	public String index() {
		return "admin/univ/index";
	}
	
	@GetMapping("/courses")
	public String course(Model model) {
		List<Course> courses = courseRepository.findAll();
		
		model.addAttribute("courses",courses);
		
		return "admin/univ/courses";
	}
	
	@GetMapping("/students")
	public String student(Model model) {
		List<Student> students = studentRepository.findAll();
		
		
		model.addAttribute("students", students);
		
		return "admin/univ/students";
	}
	
	@GetMapping("/course-details/{id}")
	public String courseDetail(@PathVariable(name="id")Integer id,Model model) {
		Course course = courseRepository.getReferenceById(id);
		List<Attendance> attendance = attendanceRepository.findByCourseCourseId(course.getCourseId());
		int attendStudentNum = attendance.size();
		model.addAttribute("course",course);
		model.addAttribute("attendStudentNum",attendStudentNum);
		
		return "admin/univ/course-details";
	}

}
