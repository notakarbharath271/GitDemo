package com.restassureddemo.bdd_style;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GetMethodLocalhost {
	@Test
	public void getMethodlocalhost() {
		RestAssured
			.given()
				.baseUri("http://localhost:3000/")
				.header("Content-Type","application/json")
			.when()
				.get("employees")
				.prettyPrint();
			
	}

}
