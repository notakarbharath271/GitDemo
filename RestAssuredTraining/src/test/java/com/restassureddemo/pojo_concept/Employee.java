package com.restassureddemo.pojo_concept;

import java.util.Arrays;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import static io.restassured.RestAssured.*;

public class Employee {

	@Test
	public void pojotojsonobject() throws JsonProcessingException {

		EmployeePojo empPojo = new EmployeePojo();

		empPojo.setEmployee_name("Raju");
		empPojo.setEmployee_salary(350000);
		empPojo.setEmploye_age(32);
		empPojo.setSkills(Arrays.asList("Java", "Selenium", ".Net", "Ruby", "RestAssured", "Cucumber"));

		System.out.println(empPojo.getEmployee_name());
		System.out.println(empPojo.getEmployee_salary());
		System.out.println(empPojo.getEmploye_age());
		System.out.println(empPojo.getSkills());

		// Create object for ObjectMapper class which from Jackson library

		ObjectMapper objMapper = new ObjectMapper();
		String jsonObject = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(empPojo);
		System.out.println(jsonObject);

		// post -- create new resource in server

		given()
			.baseUri("http://localhost:3000")
			.header("Content-Type", "application/json")
			.body(jsonObject)
		.when()
			.post("/employees")
		.then()
			.log()
			.all();

	}

}
