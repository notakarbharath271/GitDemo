package com.restassureddemo.PutRequest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateEmployeeUsingPut {
	
	@Test
	public void updateAnEmployee(){
		
		// https://petstore.swagger.io/
		
		RestAssured.baseURI = "https://petstore.swagger.io/";
		
		RequestSpecification requestSpecification =  RestAssured.given()
				.header("Content_Type","application/json")
				.header("accept","application/json")
				.body("{\r\n"
						+ "  \"id\": 0,\r\n"
						+ "  \"category\": {\r\n"
						+ "    \"id\": 0,\r\n"
						+ "    \"name\": \"string\"\r\n"
						+ "  },\r\n"
						+ "  \"name\": \"doggie\",\r\n"
						+ "  \"photoUrls\": [\r\n"
						+ "    \"string\"\r\n"
						+ "  ],\r\n"
						+ "  \"tags\": [\r\n"
						+ "    {\r\n"
						+ "      \"id\": 0,\r\n"
						+ "      \"name\": \"string\"\r\n"
						+ "    }\r\n"
						+ "  ],\r\n"
						+ "  \"status\": \"available\"\r\n"
						+ "}");
		
		
		Response response = requestSpecification.request(Method.PUT,"v2/pet/9223372000001084000");
		System.out.println(response.asPrettyString());
		System.out.println(response.statusCode());
		System.out.println(response.getSessionId());
		
		
		
		
	}

}
