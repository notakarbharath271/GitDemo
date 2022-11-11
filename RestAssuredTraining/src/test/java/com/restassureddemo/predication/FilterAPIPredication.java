package com.restassureddemo.predication;

import static com.jayway.jsonpath.Criteria.where;
import static com.jayway.jsonpath.Filter.filter;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.jayway.jsonpath.Criteria;
import com.jayway.jsonpath.Filter;
import com.jayway.jsonpath.JsonPath;

public class FilterAPIPredication {

	
    File jsonFile = new File("src/test/resources/bookstore.json");
	public void filterAPIOne() throws IOException {
		
		Filter pricelessthenTen = 	Filter.filter(
				Criteria.where("price").lt(10)					
				);
		
		List <Object> results = JsonPath.parse(jsonFile).read("$.store.book[?]",pricelessthenTen);
		System.out.println(results);
	}
	
	public void secondFilter() throws IOException {
		Filter secondCriteria = Filter.filter(Criteria.where("price").lt(10).and("category").is("fiction"));
	List<Map<String,Object>> result2 = 	JsonPath.parse(jsonFile).read("$.store.book[?]",secondCriteria);
	System.out.println(result2);
	System.out.println(result2.get(0).get("title"));
	}
	
	public void thirdFilter() throws IOException {
		
		Filter thirdCriteria =  filter(where("price").gt(10).and("category").is("fiction"));
		
		List<Map<String,Object>> result3 =  JsonPath.parse(jsonFile).read("$.store.book[?]",thirdCriteria);
		System.out.println(result3);
		
	}
	public static void main(String[] args) throws IOException {
		FilterAPIPredication filterAPIPredication = new FilterAPIPredication();
		filterAPIPredication.thirdFilter();
	}

}
