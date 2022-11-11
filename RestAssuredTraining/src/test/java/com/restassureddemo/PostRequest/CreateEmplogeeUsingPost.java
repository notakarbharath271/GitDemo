package com.restassureddemo.PostRequest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateEmplogeeUsingPost {
	
	@Test
	public void createEmployee() {
		
		//end point : https://dummy.restapiexample.com/api/v1/create
		RestAssured.baseURI = "https://dummy.restapiexample.com/";
		
		RequestSpecification requestSpecification= RestAssured.given()
		.header("Content-Type","application/json")
		.body("{\r\n"
				+ "  \"name\": \"test\",\r\n"
				+ "  \"salary\": \"123\",\r\n"
				+ "  \"age\": \"23\"\r\n"
				+ "}");
		Response response = requestSpecification.request(Method.POST,"api/v1/create");
		String responsebody = response.asPrettyString();
		System.out.println(responsebody);
		String statusline = response.getStatusLine();
		System.out.println(statusline);
		int statuscode = response.statusCode();
		System.out.println(statuscode);
		
	}

}
