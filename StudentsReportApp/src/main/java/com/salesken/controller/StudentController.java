package com.salesken.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.salesken.exceptions.StudentException;
import com.salesken.model.Semester;
import com.salesken.model.Student;
import com.salesken.repository.StudentRepo;
import com.salesken.service.StudentServiceImpl;

import jakarta.validation.Valid;

@RestController
public class StudentController {

	@Autowired
	private StudentServiceImpl service;
	
	@Autowired
	private StudentRepo sRepo;
	
	@GetMapping("/home")
	public String home() {
		return "welcome to Student Report System";
	}
	
	
	@PostMapping("/students")
	public ResponseEntity<Student> saveStudent (@Valid @RequestBody Student student) throws StudentException {
		
		
		
		Student student2=service.addStudent(student);
		
		return new ResponseEntity<Student>(student2, HttpStatus.CREATED);
		
	}
	
	@PostMapping("/marks")
	public ResponseEntity<Student> addMarks(@RequestParam("id") Integer id , @Valid @RequestBody Semester semester) throws StudentException {
		
		Student student=service.addStudentMarks(id, semester);
		
		return new ResponseEntity<Student>(student, HttpStatus.CREATED);
		
	}
	
	@GetMapping("students/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") Integer id) throws StudentException {
		
		Student student=service.getStudentById(id);
		
		return new ResponseEntity<Student>(student, HttpStatus.OK);
	}
	
	
	@GetMapping("/Students")
	public ResponseEntity<List<Student>> getAllStudents() throws StudentException{
		
		List<Student> studentList=service.getStudentsList();
		
		
		return new ResponseEntity<List<Student>>(studentList, HttpStatus.OK);
		
	}
	
	
	@DeleteMapping("students")
	public ResponseEntity<String> deleteStudentById(@RequestParam("id") Integer id) throws StudentException {
		
		String str=service.deleteStudentById(id);
		
		return new ResponseEntity<String>(str, HttpStatus.OK);
	}
	
	
	
	@GetMapping("/marks/{sid}")
	public ResponseEntity<String> avgPercentageOfClass(@PathVariable("sid") Integer semid) {
		
		Double avg=service.avgPercentageOfAllStudents(semid);
		
		String str= "average percentage of class :="+avg +" %";
		
		return new ResponseEntity<String>(str, HttpStatus.OK);
		
	}
	
	
	@GetMapping("/students")
	public ResponseEntity<Map<Integer, Integer>> top2() throws StudentException{
		
		Map<Integer, Integer> topper=service.top2();
		
		
		return new ResponseEntity<Map<Integer,Integer>>(topper, HttpStatus.OK);
		
	}


	
}
