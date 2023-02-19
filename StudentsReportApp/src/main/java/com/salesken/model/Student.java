package com.salesken.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(indexName = "Student")
@AllArgsConstructor
@NoArgsConstructor
public class Student {

	@Id
	private Integer id;
	
	@Field(type = FieldType.Text,name = "name")
	private String name;
	
	
	 @Field(type = FieldType.Auto, name = "semesters")
	 @JsonIgnore
     private List<Semester> semesters;


	public Student(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", semesters=" + semesters + "]";
	}
	 
	 
	
}
