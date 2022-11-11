package com.restassureddemo.jsonschema;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion.VersionFlag;
import com.networknt.schema.ValidationMessage;

public class NetworkntValidation {

	@Test
	public void validationSchema() throws IOException {

		ObjectMapper mapper = new ObjectMapper();
		
		JsonSchemaFactory factory = JsonSchemaFactory.getInstance(VersionFlag.V4);
		File inputjsonfile = new File("src/test/resources/JsonInputPayload.json");
		InputStream jsonSchema = new FileInputStream("src/test/resources/JsonSchema.json");
		JsonNode jsonNode = mapper.readTree(inputjsonfile);
		JsonSchema schema = factory.getSchema(jsonSchema);
		Set<ValidationMessage> result = schema.validate(jsonNode);
		
		if(result.isEmpty()) {
			System.out.println("No validation error");
		}else {
			for (ValidationMessage message : result) {
				System.out.println(message);
				
			}
		}
		
	}

}
