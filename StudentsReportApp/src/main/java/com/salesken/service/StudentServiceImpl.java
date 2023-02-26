package com.salesken.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesken.exceptions.StudentException;
import com.salesken.model.Semester;
import com.salesken.model.Student;
import com.salesken.repository.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo sRepo;
	
	
	
	@Override
	public Student addStudent(Student student) throws StudentException {
		// TODO Auto-generated method stub
		
		Optional<Student> stu=sRepo.findById(student.getId());
		
		if(stu.isPresent()) {
			throw new StudentException("student already present with id :- "+ student.getId());
		}
		else {
			return sRepo.save(student);
		 
		}
		
	}

	@Override
	public Student addStudentMarks(Integer id, Semester semester) throws StudentException {
		// TODO Auto-generated method stub
		
		Optional<Student> opt=sRepo.findById(id);
		
	
			
			if(opt.isPresent()) {
				Student student=opt.get();
				
				student.getSemesters().add(semester);
				
				return sRepo.save(student);
				
				
			}else {
				throw new StudentException("Student not found with id : "+ id);
			}
				
	
	}

	@Override
	public Student getStudentById(Integer id) throws StudentException {
		// TODO Auto-generated method stub
	
		Optional<Student> opt=sRepo.findById(id);
		
		
		
		if(opt.isPresent()) {
			Student student=opt.get();
			
			return student;
		}else {
			throw new StudentException("Student not found with id : "+ id);
		}
			
	}
	
	
	
	@Override
	public List<Student> getStudentsList() throws StudentException {
		// TODO Auto-generated method stub

		        Iterable<Student> itr =sRepo.findAll();
		        
		      
	            List<Student> studentList = new ArrayList<>();
	            for (Student s : itr) {
	                studentList.add(s);
	            }
	            
	            if(studentList.size()==0) {
	            	throw new StudentException("Student not found");
	            }
		        
        return studentList;
		
	}

	@Override
	public String deleteStudentById(Integer id) throws StudentException {
		// TODO Auto-generated method stub
		

              Optional<Student> opt=sRepo.findById(id);
		
		if(opt.isPresent()) {
			
			       sRepo.deleteById(id);
			
			return "student delected successfully";
		}else {
			throw new StudentException("Student not found with id : "+ id);
		}

	}
	
	
	

	@Override
	public Double avgPercentageOfAllStudents(Integer sid) {
		// TODO Auto-generated method stub
		
		Double average=0.0;
		
		List<Double> percentList =new ArrayList <>();
		
		Iterable<Student> itr=sRepo.findAll();
		
		for(Student s: itr ) {
			
			List<Semester> li=s.getSemesters();
			
			
			for(Semester sem:li) {
				
				if(sem.getSid()==sid) {
					Double percent= (double)((sem.getEnglish()+ sem.getMaths() + sem.getScience())*100)/300;
						
					percentList.add(percent);
				}
				
			}
			
		}
		
		for(Double d:percentList) {
			average+=d;
		}
		
		
		average=average/percentList.size();
		
		
		return average;
	}

	@Override
	public Map<Integer, Integer> top2() throws StudentException {
		// TODO Auto-generated method stub
		
		HashMap<Integer, Integer> record =new HashMap<>();
		
		Iterable<Student> itr=sRepo.findAll();
		
		for(Student s : itr) {
			
			
                  List<Semester> li=s.getSemesters();
			
			Integer sum=0;
			for(Semester sem:li) {
				
				sum+=(sem.getEnglish() + sem.getMaths() + sem.getScience());
				
			}
			
			record.put(s.getId(),sum);
			
		}
	
		
		
		
		
		List<Map.Entry<Integer, Integer>> list =new ArrayList<>(record.entrySet());
		
		Collections.sort(list,new Comparator<Map.Entry<Integer, Integer>>() {

			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				// TODO Auto-generated method stub
				return o2.getValue()-o1.getValue();
				
			}
		});
		
		
//		for(Map.Entry<Integer, Integer> entry :list) {
//			System.out.println(entry.getValue());
//		}
//		
		
		
		
		
		LinkedHashMap<Integer, Integer> topper = new LinkedHashMap<>();
		
		
		    int count=0;
		
		
		for(Map.Entry<Integer, Integer> e: list) {
			
			if(count==2) {
				break;
			}
			
			topper.put(e.getKey(), e.getValue());
			count++;
			
		}
		
		if(topper.size()<2) {
			throw new StudentException("two students not found");
		}
		
		
		return topper;
	}


	
	
}
