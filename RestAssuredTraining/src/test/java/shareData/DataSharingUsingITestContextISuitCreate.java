package shareData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class DataSharingUsingITestContextISuitCreate {

	FileInputStream jsonFile;

	@BeforeTest
	public FileInputStream readjsonfile() {
		try {
			jsonFile = new FileInputStream("src/test/resources/employee.json");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonFile;
	}

	@Test
	public void createEmployee(ITestContext context) {
	int id = RestAssured.given().baseUri("http://localhost:3000").basePath("/employees").contentType(ContentType.JSON)
				.body(jsonFile).log().all().when().post().then().extract().jsonPath().getInt("id");
		context.getSuite().setAttribute("employeeId", id);
	}
}