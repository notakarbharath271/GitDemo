package shareData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class ShareDataAmongMethodsUsingMap {
	
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
	int id =	RestAssured.given()
			.baseUri("http://localhost:3000")
			.basePath("/employees")
			.contentType(ContentType.JSON)
			.body(jsonFile).when().post()
			.then().extract().jsonPath().getInt("id");
	DataShareUsingMap.setValue("employeeId", id);
		
	}
	
	@Test(priority = 2)
	public void getEmployee() {
	int id =	(int) DataShareUsingMap.getValue("employeeId");
		RestAssured.given()
		.baseUri("http://localhost:3000")
		.basePath("/employees/"+id)
		.contentType(ContentType.JSON)
		.when()
		.get()
		.prettyPrint();
		
	}

	
	

}
