package com.salesken.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Document(indexName ="student")
public class Student {

	@Id
	@Min(1)
	private Integer id;
	
	@Field
	@NotNull
	private String name;
	
	@Field(type = FieldType.Auto, name = "semesters")
    private List<Semester> semesters=new ArrayList<>();

	
	 public Student(Integer id, String name, List<Semester> semesters) {
		super();
		this.id = id;
		this.name = name;
		this.semesters = semesters;
	}


	public Student(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}


	public Student() {
		super();
	}




	 
	 
	
}
