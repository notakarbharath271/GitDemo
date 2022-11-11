package shareData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class TestModuleOneWithThreadLocal {
	
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
			.body(jsonFile).log().all().when().post()
			.then().extract().jsonPath().getInt("id");
	ThreadLocalDataShare.setValue("employeeId", id);
	System.out.println("Thread is : "+Thread.currentThread().getId()+" the employee is created for this id : "+ThreadLocalDataShare.getValue("employeeId"));
		
	}
	
	@Test(priority = 2)
	public void getEmployee() {
	int id =	(int) ThreadLocalDataShare.getValue("employeeId");
	
	System.out.println("Thread is : "+Thread.currentThread().getId()+" the employee got retrived for this id  : "+ThreadLocalDataShare.getValue("employeeId"));

		RestAssured.given()
		.baseUri("http://localhost:3000")
		.basePath("/employees/"+id)
		.contentType(ContentType.JSON)
		.log().all()
		.when()
		.get()
		.prettyPrint();
		
	}

	
	

}
