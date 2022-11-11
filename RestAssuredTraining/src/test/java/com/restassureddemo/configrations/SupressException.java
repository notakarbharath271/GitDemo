package com.restassureddemo.configrations;

import java.util.List;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;

public class SupressException {
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
	public static void supressexception() {
		
		
		Configuration conf = 	Configuration.defaultConfiguration();
		conf = conf.addOptions(Option.ALWAYS_RETURN_LIST);
		conf = conf.addOptions(Option.SUPPRESS_EXCEPTIONS);
		
		List<Integer> age =  JsonPath.using(conf).parse(jsonpayload).read("$.[1].age");
		System.out.println(age);

	}
	
	public static void main(String[] args) {
		supressexception();
	}

}
