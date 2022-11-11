package shareData;

import org.testng.ITestContext;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class DataSharingUsingItestContextGet {
	@Test
	public void getEmployee(ITestContext context) {
		
			RestAssured.given()
			.baseUri("http://localhost:3000")
			.basePath("/employees/"+context.getAttribute("employeeId"))
			.contentType(ContentType.JSON)
			.log().all()
			.when()
			.get()
			.prettyPrint();
	}
}
