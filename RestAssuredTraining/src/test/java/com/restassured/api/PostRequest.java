package com.restassured.api;
import static io.restassured.RestAssured.given;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.SneakyThrows;

public class PostRequest {
@Test
	public void postMethod() {
		
	Employee employee=	Employee.builder().setFname("Bharath").setId(100).setLname("Kumar").setEmail("bharathkumar@in.com").build();

	Response res = 	given()
		.baseUri("http://localhost:3000")
		.basePath("/employees")
		.contentType(ContentType.JSON)
		.body(employee)
		.post();
	res.prettyPrint();
	}
@SneakyThrows
public String readdata(String filepath) {
	return new String(Files.readAllBytes(Paths.get(filepath)));
}

}
