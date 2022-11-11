package com.restassureddemo.bdd_style;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DeleteEmployee {
	
	@Test
	public void deleteemployee() {
		
		RestAssured
			.given()
				.baseUri("http://localhost:3000/")
				.header("Content-Type","application.json")
			.when()
				.delete("employees/26")
			.prettyPrint();
		
		
	}

}
