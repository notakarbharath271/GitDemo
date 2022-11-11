package com.restassureddemo.serilizationanddeserilization;

import io.restassured.RestAssured;

public class ArrayResponseToPojo {

	public static void main(String[] args) {

		Address[] address = RestAssured.get("https://run.mocky.io/v3/108572ec-0568-4961-b13e-07c3f8958758").as(Address[].class);
		
		System.out.println(address.length);
		System.out.println(address[0].getHouseNo());
		System.out.println(address[1].getCountry());
		

	}

}
