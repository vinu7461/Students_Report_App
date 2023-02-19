package com.salesken.model;

import lombok.Data;

@Data
public class Semester {

	private Integer sid;
	
	private Integer english;
	
	private Integer maths;
	
	private Integer science;
	
	public Semester(int sid) {  
	      this.sid = sid;
	    }
}
