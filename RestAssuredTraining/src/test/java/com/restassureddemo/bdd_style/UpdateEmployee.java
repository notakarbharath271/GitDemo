package com.restassureddemo.bdd_style;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class UpdateEmployee {
	@Test
	public void updateemployee() {
		
		RestAssured
		.given()
			.baseUri("http://localhost:3000")
			.header("Content-Type","application/json")
			.body("{\r\n"
					+ "      \"employee_name\": \"Rohit Sharma\",\r\n"
					+ "      \"employee_salary\": 600000,\r\n"
					+ "      \"employee_age\": 45,\r\n"
					+ "      \"profile_image\": \"\"\r\n"
					+ "    }")
		.when()
			.put("/employees/25")
			.prettyPrint();
	}
}
