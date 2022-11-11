package com.restassureddemo.pojo_concept;

import java.util.Map;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;

public class DeserilizationUsingAsFunction {

	public static void main(String[] args) {


		Map<String, Object> response = RestAssured.given()
			.baseUri("http://localhost:3000")
			.header("COntent-Type","application/json")
			.when()
			.get("/employees/35")
			.then()
			.extract()
			.body()
			.as(new TypeRef <Map<String, Object>>() {
			});
		
		System.out.println(response);
		
		System.out.println(response.get("id"));
		System.out.println(response.get("employee_name"));
		System.out.println(response.get("employee_salary"));
		System.out.println(response.get("employee_age"));
		System.out.println(response.get("Skills"));

	}

}
