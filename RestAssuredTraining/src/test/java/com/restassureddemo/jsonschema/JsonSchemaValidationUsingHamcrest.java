package com.restassureddemo.jsonschema;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

public class JsonSchemaValidationUsingHamcrest {
	@Test
	public void jsonSchemaValidation() throws IOException {
		
		File inputJsonfile = new File("src/test/resources/JsonInputPayload.json");
		String jsonString = FileUtils.readFileToString(inputJsonfile,"UTF-8");
		File jsonSchemafile = new  File("src/test/resources/JsonSchema.json");
		
		MatcherAssert.assertThat(jsonString,JsonSchemaValidator.matchesJsonSchema(jsonSchemafile));
		
		
		
	}

}
