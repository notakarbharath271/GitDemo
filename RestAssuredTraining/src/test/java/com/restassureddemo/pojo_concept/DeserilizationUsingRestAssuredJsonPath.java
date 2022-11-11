package com.restassureddemo.pojo_concept;

import java.io.File;

import io.restassured.path.json.JsonPath;

public class DeserilizationUsingRestAssuredJsonPath {

	
	  static File empJsonFile = new File("src/test/resources/employee.json");
	public static void main(String[] args) {

		JsonPath jsonpath = JsonPath.from(empJsonFile);
		EmployeePojo emp = jsonpath.getObject("$",EmployeePojo.class);
		
		System.out.println(emp.getEmployee_name());
		System.out.println(emp.getEmployee_salary());
		System.out.println(emp.getEmploye_age());
		System.out.println(emp.getSkills());

	}
	

}
