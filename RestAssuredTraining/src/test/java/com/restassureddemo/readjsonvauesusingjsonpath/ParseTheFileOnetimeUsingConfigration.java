package com.restassureddemo.readjsonvauesusingjsonpath;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;

public class ParseTheFileOnetimeUsingConfigration {

	public static void parseOneTime() throws IOException {
		File jsonfile = new File("src/test/resources/bookstore.json");
		String jsonString = FileUtils.readFileToString(jsonfile,"UTF-8");

		Object parseJsonDoc = Configuration.defaultConfiguration().jsonProvider().parse(jsonString);

		List<Object>categorylist = JsonPath.read(parseJsonDoc,"$..category");

		for (Object category : categorylist) {
			System.out.println(category);
		}		

	}
	public static void main(String[] args) throws IOException {
		parseOneTime();
	}

}
