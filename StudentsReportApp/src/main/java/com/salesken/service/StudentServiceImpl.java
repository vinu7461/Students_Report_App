package com.salesken.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesken.model.Semester;
import com.salesken.model.Student;
import com.salesken.repository.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepo sRepo;
	
	
	@Override
	public Student addStudent(Student student) {
		// TODO Auto-generated method stub
		
		return sRepo.save(student);
		
	}

	@Override
	public String addStudentMarks(Integer id, Semester semester) {
		// TODO Auto-generated method stub
		
		Optional<Student> opt=sRepo.findById(id);
		
	
			
			if(opt.isPresent()) {
				Student student=opt.get();
				
				student.getSemesters().add(semester);
				
				return student.toString();
			}else {
				return "student not present with this id";
			}
				
		
		
		
		
	}

	@Override
	public String getStudentById(Integer id) {
		// TODO Auto-generated method stub
	
		Optional<Student> opt=sRepo.findById(id);
		
		
		
		if(opt.isPresent()) {
			Student student=opt.get();
			
			return student.toString();
		}else {
			return "student not present with this id";
		}
			
	}

	@Override
	public Double avgPercentageOfAllStudents(Integer sid) {
		// TODO Auto-generated method stub
		
		Double avg=0.0;
		
		
		
		
		return avg;
	}

}
