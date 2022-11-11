package demopa;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Getmethod {
	@Test
	public void getmethod() {
	Response response =	RestAssured.given()
		.baseUri("http://localhost:3000")
		.basePath("/employees")
		.get();
	response.prettyPrint();
	int statiscode = response.getStatusCode();
	Assert.assertEquals(statiscode, 200);
	List<String> list =response.jsonPath().getList("$");
	
	}
	public void method() throws JsonProcessingException {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("id", "12");
		map.put("fname", "Bharath");
		map.put("lname", "N");
		map.put("email", "bharathkumar@in.com");
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.writerWithDefaultPrettyPrinter().writeValueAsString(mapper);
		
	}

}
