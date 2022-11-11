package com.restassureddemo.serilizationanddeserilization;

import io.restassured.RestAssured;

public class JsonResponseToPojoClass {

	public static void main(String[] args) {
		
		Employee  emp = RestAssured.get("https://run.mocky.io/v3/93f803df-a89f-4c53-b871-79e5049ae689").as(Employee.class);
		System.out.println(emp.getFirstname());
		System.out.println(emp.getLastname());
		System.out.println(emp.getAge());
		System.out.println(emp.getSkills());
		
		
		
		

	}

}
