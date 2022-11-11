package com.restassureddemo.pojo_concept;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;

public class DeserilizationDemo {
	
	File empJsonFile = new File("src/test/resources/employee.json");
	
	public  void deserilization() throws StreamReadException, DatabindException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		EmployeePojo emp = mapper.readValue(empJsonFile,EmployeePojo.class);
		
		System.out.println(emp.getEmployee_name());
		System.out.println(emp.getEmployee_salary());
		System.out.println(emp.getEmploye_age());
		System.out.println(emp.getSkills());
	}
	public void usingJaywayJsonPath() throws IOException {
		JacksonMappingProvider  jacksonMappingProvider = new JacksonMappingProvider();
		
		Configuration  config = Configuration.builder().mappingProvider(jacksonMappingProvider).build();
		
		EmployeePojo employee = JsonPath.using(config).parse(empJsonFile).read("$",EmployeePojo.class);
		System.out.println(employee.getEmployee_name());
		System.out.println(employee.getEmployee_salary());
		System.out.println(employee.getEmploye_age());
		System.out.println(employee.getSkills());
	}
	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		DeserilizationDemo demo = new DeserilizationDemo();
		demo.usingJaywayJsonPath();
	}
	

}
