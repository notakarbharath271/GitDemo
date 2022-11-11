package com.restassureddemo.serialization;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class SerializationDemo {
	@Test
	public void serialization() {
		
		Map<String,Object> jsonbody = new LinkedHashMap<String,Object>();
		
		jsonbody.put("employee_name", "Lava");
		jsonbody.put("employee_salary", 350000);
		jsonbody.put("employe_age", 28);
		
		List<String> jsonlist = new LinkedList<String>();
		jsonlist.add("Java");
		jsonlist.add("Selenium");
		jsonlist.add("RestAssured");
		jsonlist.add("Cucumber");
		
		
		jsonbody.put("Skills", jsonlist);
		
		System.out.println(jsonbody);
		
		given().baseUri("http://localhost:3000")
		.header("Content-Type","application/json")
		.body(jsonbody)
		.log()
		.all()
		.when()
		.post("/employees")
		.then()
		.log()
		.all();
	}

}
