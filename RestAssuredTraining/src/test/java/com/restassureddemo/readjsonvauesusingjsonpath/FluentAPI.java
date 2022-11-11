package com.restassureddemo.readjsonvauesusingjsonpath;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class FluentAPI {
	
	public static void  fluentapi() throws IOException {
		
		
		File jsonfiel = new File("src/test/resources/bookstore.json");
		
		DocumentContext docContext =  JsonPath.parse(jsonfiel);
		
		List<Object> titlelist = docContext.read("$..title");
		
		for (Object title : titlelist) {
			System.out.println(title);
			
		}
		
	}
	
	public static void  fluentapiConfig() throws IOException {
		File jsonfiel = new File("src/test/resources/bookstore.json");
		
	Configuration configuration = 	Configuration.defaultConfiguration();
	List<Object> listisbn = JsonPath.using(configuration).parse(jsonfiel).read("$..isbn");
	for (Object isbn : listisbn) {
		System.out.println(isbn);
	}
	}
	public static void main(String[] args) throws IOException {
		fluentapi();
		System.out.println("------------------");
		fluentapiConfig();
	}

}
