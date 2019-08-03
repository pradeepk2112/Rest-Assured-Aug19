package servicenow;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetAllIncidents {
	
	
	@Test
	public void getIncidents() {
		
		// EndPoint
		RestAssured.baseURI = "https://dev82291.service-now.com/api/now/table/incident";
		
		// Authorization
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		
		// Request
		Response response = RestAssured.get();
		
		// Print
		//response.prettyPrint();
		
		int statusCode = response.statusCode();
		System.out.println(statusCode);
		
		String statusLine = response.statusLine();
		System.out.println(statusLine);
		
		// Convert to Json
		JsonPath responseJson = response.jsonPath();
		
		// Pick your field
		List<String> allIncidents = responseJson.getList("result.number");
		System.out.println(allIncidents.size());
		
		
		
		
		
		
	}

}
