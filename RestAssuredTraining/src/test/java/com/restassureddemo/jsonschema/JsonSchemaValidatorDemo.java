package com.restassureddemo.jsonschema;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;

public class JsonSchemaValidatorDemo {
	
	@Test
	public void jsonschemavalidator() {
	
		File jsonpayloadfile = new File("src/test/resources/JsonInputPayload.json");
		
		RestAssured.given()
			.baseUri("http://localhost:3000")
			.header("Content-Type","application/json")
			.body(jsonpayloadfile)
			.when()
				.post("/employees")
			.then()
				.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("JsonSchema.json"));
		
		
	}

}
