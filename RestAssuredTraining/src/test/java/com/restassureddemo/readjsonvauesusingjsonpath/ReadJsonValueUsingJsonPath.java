package com.restassureddemo.readjsonvauesusingjsonpath;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.jayway.jsonpath.JsonPath;

public class ReadJsonValueUsingJsonPath {


	public static void readjsonvalue() throws IOException {
		File jsonfile = new File("src/test/resources/bookstore.json");
		List<Object> pricelsit = JsonPath.read(jsonfile,"$..price");
		for (Object price : pricelsit) {
			System.out.println(price);

		}
	}
	public static void main(String[] args) throws IOException {

		readjsonvalue();


	}

}
