package com.restassureddemo.configrations;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;

public class HandlingPathNotFoundExceptionDemo {
	
	public static String json = "{\r\n"
			+ "      \"id\": 1,\r\n"
			+ "      \"employee_name\": \"Tiger Nixon\",\r\n"
			+ "      \"employee_salary\": 320800,\r\n"
			+ "      \"employee_age\": 61,\r\n"
			+ "      \"profile_image\": \"\"\r\n"
			+ "    }";

	public static void main(String[] args) {
		
		Configuration configuration = Configuration.defaultConfiguration();
		configuration = configuration.addOptions(Option.DEFAULT_PATH_LEAF_TO_NULL);
		Object result2 = JsonPath.using(configuration).parse(json).read("$.employee_gender");
		System.out.println(result2); //Null
	}

}
