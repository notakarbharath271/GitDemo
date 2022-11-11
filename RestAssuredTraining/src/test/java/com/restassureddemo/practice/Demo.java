package com.restassureddemo.practice;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class Demo {
	
	@Test
	public void getUser() {
		Response res = null;
	res=	RestAssured.given().get("https://dummy.restapiexample.com/api/v1/employees");
	
	System.out.println("Get response as string : "+res.asString());
	System.out.println("Get response as string : "+res.prettyPrint());
	//System.out.println(res.jsonPath().getString("status"));
	
	System.out.println("Get response using jsonpath abstract method : "+res.jsonPath().getJsonObject("$"));

	MatcherAssert.assertThat(res.asString(), JsonSchemaValidator.matchesJsonSchemaInClasspath("JsonSchemaValidator.json"));
	String expected_total = "success";
	String actual_total = res.jsonPath().getString("status");
	}
	
	@Test
	public void countduplicateChat() {
		
		String str1 = "abcvdesahabaxhs";
		String str2 = "abcvdesahabaxhssfdfxdsz";
		
		Set arrSet1 = new HashSet(listofchar(str1));
		Set arrSet2 = new HashSet(listofchar(str2));
		arrSet1.retainAll(arrSet2);
		System.out.println(arrSet1.size());
	}
	public static List listofchar(String str) {
		
		List templist = new ArrayList();
		char[] cha = str.toCharArray();
		
		for (char c : cha) {
			templist.add(String.valueOf(c));
			
		}
		return templist;
		
		
	}
	
	@Test
	public void swaptwoStrings() {
		String s1 = "Bharath";
		String s2 = "Sarath";
		System.out.println("Before swapping "+ s1  +" and "+s2);
		s1 =s1+s2;
		//System.out.println(s1);
		s2 = s1.substring(0,s1.length()-s2.length());
		//System.out.println(s2);
		s1 = s1.substring(s2.length());
		System.out.println("After swapping "+ s1  +" and "+s2);
	}
public static void main(String[] args) {
	List list = Arrays.asList(1,2);
	List num = list;
	num.add(3.14);
	
}

@Test
public void test1() {
	
	RestAssured.given().body(new File(System.getProperty("user.dir")+"/src/test/resources/data.json")).log().all().post();
}

@Test
public void test2() throws IOException {
	String resp = new String(Files.readAllBytes(Paths.get( System.getProperty("user.dir")+"/src/test/resources/data.json")));
	String updatedresp =resp.replace("12",String.valueOf(new Faker().number().numberBetween(0, 100)));
	String updatedresp1 = updatedresp.replace("fname",new Faker().name().firstName());
	String updatedresp2 = updatedresp1.replace("lname", new Faker().name().lastName());
	RestAssured.given().body(updatedresp2).log().all().post();
}
@Test
public void test3() {
	
Map<String,Object> map = new LinkedHashMap<>();
map.put("id", new Faker().number().numberBetween(0, 100));
map.put("firstname", new Faker().name().firstName());
map.put("lastname", new Faker().name().lastName());
map.put("email", "firstnamelastname@in.com");
map.put("email", "firstnamelastname1@in.com");

List<String> list = new LinkedList<String>();
list.add("Idly");
list.add("chapathi");
list.add("poory");

map.put("breakfast", list);
Response response = RestAssured.given().body(map).log().all().post();
response.prettyPrint();
}
}
