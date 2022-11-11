package com.restassureddemo.bdd_style;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class CreateEmployeeExternalFile {
	@Test
	public void createEmployeeUsingExternalFile() {
		// C:\Users\bhara\eclipse-workspace\RestAssuredTraining\Payload\postemployee.json
		
		String path = System.getProperty("user.dir");
		
		//System.out.println(path);
		
		File jsonFile = new File(path+"\\Payload\\postemployee.json");
		
		given()
		.baseUri("http://localhost:3000/")
			.header("Content-Type","application/json")
			.contentType(ContentType.JSON)
			.body(jsonFile)
	.when()
		.post("employees")
		.prettyPrint();
		
	}

}
