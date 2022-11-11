package com.restassureddemo.serilizationanddeserilization;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;

public class ListTypeRef {
	
	public static void main(String[] args) {
		List<Address>  address= RestAssured.get("https://run.mocky.io/v3/108572ec-0568-4961-b13e-07c3f8958758").as(new TypeRef<List<Address>>() {
		});
		
		System.out.println(address.size());
		System.out.println(address.get(0).getCity());
		System.out.println(address.get(1).getHouseNo());
		
		
	}

}
