package com.restassureddemo.bdd_style;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetMethod {
	@Test
	public void getMethod() {
		/* With out ststic import
		RestAssured.given()
			.baseUri("https://petstore.swagger.io/")
			.basePath("v2/user/bharath")
			.header("accept","application/json")
		.when()
			.get()
			
		.then()
			.assertThat()
			.statusCode(200)
			.log().all()
			;
		*/
		// with ststic import
		given()
		.baseUri("https://petstore.swagger.io/")
		.basePath("v2/user/bharath")
		.header("accept","application/json")
	.when()
		.get()
		
	.then()
		.assertThat()
		.statusCode(200)
		.log().all();
	}

}
