package com.salesken.service;

import com.salesken.model.Semester;
import com.salesken.model.Student;

public interface StudentService {
	
	public Student addStudent(Student student );
	
	public String addStudentMarks(Integer id,Semester semester);
	
	public String getStudentById(Integer id);
	
    public Double avgPercentageOfAllStudents(Integer sid);

}
