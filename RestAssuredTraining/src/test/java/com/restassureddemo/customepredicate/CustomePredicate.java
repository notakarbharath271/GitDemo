package com.restassureddemo.customepredicate;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Predicate;

public class CustomePredicate {
	File jsonfile = new File("src/test/resources/bookstore.json");
	public void customePredicateMethod() throws IOException {
		Predicate bookisbn = new Predicate() {

			@Override
			public boolean apply(PredicateContext ctx) {
				
			boolean predicate =	ctx.item(Map.class).containsKey("isbn");
				return predicate;
			}
			
		};
	List<Map<String,Object>> results = 	JsonPath.parse(jsonfile).read("$.store.book[?].isbn",bookisbn);
	System.out.println(results);
				
	}

	public static void main(String[] args) throws IOException {
		CustomePredicate customePredicate = new CustomePredicate();
		customePredicate.customePredicateMethod();
		

	}

}
