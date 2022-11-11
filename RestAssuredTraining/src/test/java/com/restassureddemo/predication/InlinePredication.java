package com.restassureddemo.predication;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.jayway.jsonpath.JsonPath;

public class InlinePredication {

	File jsonfile = new File("src/test/resources/bookstore.json");

	public void inlinePredication() throws IOException {
		// Inline Predication
		// List<Object> result =
		// JsonPath.parse(jsonfile).read("$.store.book[?(@.price>10)].price");
		// using && in expression --> checking two conditions
		// List<Object> result =
		// JsonPath.parse(jsonfile).read("$.store.book[?(@.price>10 &&
		// @.category=='fiction')]");

		// using || in expression --> checking two conditions
		//List<Object> result = JsonPath.parse(jsonfile).read("$.store.book[?(@.price>10 || @.category=='fiction')]");
		
		//using negation (Not)
		List<Object> result = JsonPath.parse(jsonfile).read("$.store.book[?(!(@.price>10 || @.category=='fiction'))]");

		System.out.println(result);

	}

	public static void main(String[] args) throws IOException {

		InlinePredication inlinePredication = new InlinePredication();
		inlinePredication.inlinePredication();

	}

}
