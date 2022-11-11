package com.restassureddemo.bdd_style;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PostMethod {
	@Test
	public void postMethodWithArray() {
		
		RestAssured
			.given()
				.contentType(ContentType.JSON)
				.baseUri("https://petstore.swagger.io/")
				.basePath("v2/user/createWithArray")
				.body("[\r\n"
						+ "  {\r\n"
						+ "    \"id\": 1,\r\n"
						+ "    \"username\": \"bharath1\",\r\n"
						+ "    \"firstName\": \"Bharath1\",\r\n"
						+ "    \"lastName\": \"Kumar1\",\r\n"
						+ "    \"email\": \"bharath1@gmail.com\",\r\n"
						+ "    \"password\": \"bharath123\",\r\n"
						+ "    \"phone\": \"9090909090\",\r\n"
						+ "    \"userStatus\": 1\r\n"
						+ "  }\r\n"
						+ "]")
			.when()
				.post()
			.then()
				.log()
				.all()
				.assertThat()
				.statusCode(200)
			;
				
		
	}

}
