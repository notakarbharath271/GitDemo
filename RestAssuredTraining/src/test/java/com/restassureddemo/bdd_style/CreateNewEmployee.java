package com.restassureddemo.bdd_style;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateNewEmployee {
	
	@Test
	public void createEmployee() {
		given()
			.baseUri("http://localhost:3000/")
				.header("Content-Type","application/json")
				.contentType(ContentType.JSON)
				.body("{\r\n"
						+ "        \"employee_name\": \"xyz\",\r\n"
						+ "        \"employee_salary\": 350000,\r\n"
						+ "        \"employee_age\": 66,\r\n"
						+ "        \"profile_image\": \"\"\r\n"
						+ "    }")
		.when()
			.post("employees")
			.prettyPrint();
			
	}

}
