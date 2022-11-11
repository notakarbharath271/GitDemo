package com.restassureddemo.serilizationanddeserilization;

import java.util.Arrays;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerilizationAndDeserilization {

	Employee emp = new Employee();
	ObjectMapper mapper = new ObjectMapper();
	String jsonobject ;

	public void serilizor() throws JsonProcessingException {

		emp.setFirstname("Ben");
		emp.setLastname("Lee");
		emp.setAge(62);
		emp.setSkills(Arrays.asList("Java","Python","C#","Rest Assured",".Net"));

		jsonobject = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
		System.out.println(jsonobject);		

	}

	public void deserilizor() throws JsonMappingException, JsonProcessingException {
		Employee empdese = mapper.readValue(jsonobject, Employee.class);
		System.out.println(empdese.getFirstname());	
		System.out.println(empdese.getLastname());	
		System.out.println(empdese.getAge());	
		System.out.println(empdese.getSkills());	
	}

	public static void main(String[] args) throws JsonProcessingException {
		SerilizationAndDeserilization serilizationAndDeserilization = new SerilizationAndDeserilization();
		serilizationAndDeserilization.serilizor();
		System.out.println("------------------------------------------------------------------------------");
		serilizationAndDeserilization.deserilizor();
	}

}
