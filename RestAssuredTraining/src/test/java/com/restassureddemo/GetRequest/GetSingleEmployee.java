package com.restassureddemo.GetRequest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetSingleEmployee {
	@Test
	public static Object getSingleEmployee() {
		//end point : https://dummy.restapiexample.com/api/v1/employee/1
		
		RestAssured.baseURI = "https://dummy.restapiexample.com/";
		
		RequestSpecification requestSpecification =  RestAssured.given();
		Response response = requestSpecification.request(Method.GET,"api/v1/employee/1");
		System.out.println(response.asPrettyString());
		System.out.println(response.getStatusLine());
		System.out.println(response.statusCode());
		Object id =response.body().jsonPath().get("data.id");
		return id;
	}
	@Test(priority = 1)
	public void id() {
		Object id = GetSingleEmployee.getSingleEmployee();
		System.out.println(id);
		
	}
}
