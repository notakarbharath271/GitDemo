package com.restassured.api;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder(setterPrefix ="set" )
@Getter
public class Employee {
	
	private int id;
	private String fname;
	private String lname;
	private String email;
	
	

}
