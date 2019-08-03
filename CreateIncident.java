package servicenow;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateIncident {
	
	
	@Test
	public void createNewIncident() {
		
		// EndPoint
		RestAssured.baseURI = "https://dev82291.service-now.com/api/now/table/incident";
		
		// Authorization
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		
		// Request
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.post();
		
		// status code
		int status = response.getStatusCode();
		System.out.println(status);
		
		String statusLine = response.getStatusLine();
		System.out.println(statusLine);
		
		// print the incident number
		JsonPath jsonPath = response.jsonPath();
		String incidentNumber = jsonPath.get("result.number");
		System.out.println(incidentNumber);
		
		
		
		
		
		
		
		
		
		
		
	}

}
