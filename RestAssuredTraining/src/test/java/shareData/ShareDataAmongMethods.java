package shareData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class ShareDataAmongMethods {
	private int empID;
	FileInputStream jsonFile;
	@BeforeTest
	public FileInputStream readjsonfile(){
	try {
		jsonFile = new FileInputStream("src/test/resources/employee.json") ;
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return jsonFile;
	}
	@Test(priority = 1)
	public void createEmployee() {
	empID =	RestAssured.given()
			.baseUri("http://localhost:3000")
			.basePath("/employees")
			.contentType(ContentType.JSON)
			.body(jsonFile).when().post()
			.then().extract().jsonPath().getInt("id");
		
	}
	
	@Test(priority = 2)
	public void getEmployee() {
		
		RestAssured.given()
		.baseUri("http://localhost:3000")
		.basePath("/employees/"+empID)
		.contentType(ContentType.JSON)
		.when()
		.get()
		.prettyPrint();
		
	}
public void updateEmployee() {
		
		RestAssured.given()
		.baseUri("http://localhost:3000")
		.basePath("/employees/"+empID)
		.contentType(ContentType.JSON)
		.when()
		.put()
		.prettyPrint();
		
	}
	
	

}
