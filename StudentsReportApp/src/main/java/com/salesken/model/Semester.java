package com.salesken.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
public class Semester {

	@Min(1)
	@Max(2)
	private Integer sid;
	
	@Max(100)
	@Min(1)
	private Integer english;
	
	@Max(100)
	@Min(1)
	private Integer maths;
	
	@Max(100)
	@Min(1)
	private Integer science;
	
	
	public Semester(int sid) {  
	      this.sid = sid;
	    }

	public Semester(Integer sid, Integer english, Integer maths, Integer science) {
		super();
		this.sid = sid;
		this.english = english;
		this.maths = maths;
		this.science = science;
	}

	public Semester() {
		super();
	}
	
	
}