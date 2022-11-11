package com.restassureddemo.serilizationanddeserilization;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WithOutUsingPojoUpdatingDynamicPayload {
	
	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		
		 Map<String, Object> address = mapper.readValue(new File("src/test/resources/address.json"),new TypeReference<Map<String,Object>>() {
		});
		 
		 System.out.println(address.get("state"));
		 address.put("state", "AP");
		 address.put("pin","517127");
		 System.out.println(address.get("state"));
		String updatedaddress =  mapper.writerWithDefaultPrettyPrinter().writeValueAsString(address);
		System.out.println(updatedaddress);
		
		
	}

}
