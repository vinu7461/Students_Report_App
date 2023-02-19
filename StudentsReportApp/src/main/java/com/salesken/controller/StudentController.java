package com.salesken.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesken.model.Semester;
import com.salesken.model.Student;
import com.salesken.service.StudentService;
import com.salesken.service.StudentServiceImpl;

@Controller
public class StudentController {
	
	private StudentService service;
	
	@PostMapping("/Students")
	public Student saveStudent (@RequestBody Student student) {
		
		Student s=service.addStudent(student);
		
		return s;
		
	}
	
	
	public String addMarks(@RequestParam("id") Integer id,@RequestBody Semester semester) {
		
		String str=service.addStudentMarks(id, semester);
		
		return str;
		
	}
	
	
	public String studentById(@RequestParam("id") Integer id) {
		
		String str=service.getStudentById(id);
		
		return str;
	}
	
	

}
