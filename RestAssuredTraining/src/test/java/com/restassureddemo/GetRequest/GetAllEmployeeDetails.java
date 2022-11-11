package com.restassureddemo.GetRequest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAllEmployeeDetails {
	
	@Test
	public void getAllEmployee() {
		//url /end point : https://dummy.restapiexample.com/api/v1/employees
		
		RestAssured.baseURI = "https://dummy.restapiexample.com/";
		
		 RequestSpecification requestSpecification =  RestAssured.given();
		 Response response =  requestSpecification .request(Method.GET,"api/v1/employees");
		 
		 String responserbody = response.getBody().asPrettyString();
		Object id =response.body().jsonPath().get("data.id");
		System.out.println(id.toString());
		 
		 System.out.println(responserbody);
		 
		 String statusline = response.statusLine();
		 System.out.println(statusline);
		int statuscode = response.statusCode();
		System.out.println(statuscode);
		
		
		
	}
	
	

}
