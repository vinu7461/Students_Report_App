package com.salesken.service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.salesken.exceptions.StudentException;
import com.salesken.model.Semester;
import com.salesken.model.Student;

public interface StudentService {
	
	public Student addStudent(Student student ) throws StudentException;
	
	public Student addStudentMarks(Integer id,Semester semester) throws StudentException;
	
	public Student getStudentById(Integer id) throws StudentException;
	
	public List<Student> getStudentsList() throws StudentException;
	
	public String deleteStudentById(Integer id) throws StudentException;
	
    public Double avgPercentageOfAllStudents(Integer sid);
    
    public Map<Integer, Integer> top2() throws StudentException;

}
