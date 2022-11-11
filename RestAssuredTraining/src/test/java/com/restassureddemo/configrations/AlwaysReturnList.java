package com.restassureddemo.configrations;

import java.util.List;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;

public class AlwaysReturnList {

	public static String jsonpayload ="[\r\n"
			+ "    {\r\n"
			+ "    \"firstName\": \"John\",\r\n"
			+ "    \"lastName\": \"doe\",\r\n"
			+ "    \"age\": 26\r\n"
			+ "    },\r\n"
			+ " {\r\n"
			+ "    \"firstName\": \"Ben\",\r\n"
			+ "    \"lastName\": \"lee\"\r\n"
			+ "    \r\n"
			+ "     \r\n"
			+ " }\r\n"
			+ "]";
	public static void main(String[] args) {
		
		Configuration config =  Configuration.defaultConfiguration();
		config = config.addOptions(Option.ALWAYS_RETURN_LIST);
		
		List<String> result = JsonPath.using(config).parse(jsonpayload).read("$..firstName");
		System.out.println(result);

	}

}
