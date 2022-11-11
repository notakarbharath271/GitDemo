package com.restassureddemo.jsonschema;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class JsonSchemaFilewithoutClasspath {
	@Test
	public void createrecord() {
		
		File inputjsonfile = new File("src/test/resources/JsonInputPayload.json");
		File inputschemafile =  new File("src/test/resources/JsonSchema.json");
		ExtentSparkReporter	extentSparkReporter = new ExtentSparkReporter(new File("reports/index.html"));
		
	Response res=	given().baseUri("http://localhost:3000")
		.header("Content-Type","application/json")
		.body(inputjsonfile)
		.when()
		.post("/employees");

		res.prettyPrint();
	int id = 	res.jsonPath().getInt("id");
	MatcherAssert.assertThat(res.asString(), JsonSchemaValidator.matchesJsonSchema(inputschemafile));
	//pass/fail
	ExtentReports extentReports = new ExtentReports();
	
	extentReports.attachReporter(extentSparkReporter);
	ExtentTest etest  =extentReports.createTest("JsonSchemaFilewithoutClasspath");
	etest.log(Status.PASS, "The test case got passed");
	extentReports.flush();
	
	}

}
