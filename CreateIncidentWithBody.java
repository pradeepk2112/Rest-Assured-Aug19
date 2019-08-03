package servicenow;

import java.io.File;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateIncidentWithBody {
	
	@DataProvider(name="files",parallel=true)
	public String[][] getFiles(){
		String[][] files = new String[2][1];
		files[0][0] = "./data1.json";
		files[1][0] = "./data2.json";		
		return files;
	}
	
	
	@Test(dataProvider="files")
	public void createNewIncident(String fileName) {
		
		// Create File
		File jsonFile1 = new File(fileName);
		
		// EndPoint
		RestAssured.baseURI = "https://dev82291.service-now.com/api/now/table/incident";
		
		// Authorization
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		
		// Request
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body(jsonFile1)
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
