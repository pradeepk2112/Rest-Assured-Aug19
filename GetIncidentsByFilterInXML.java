package servicenow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class GetIncidentsByFilterInXML {
	
	
	@Test
	public void getIncidents() {
		
		// EndPoint
		RestAssured.baseURI = "https://dev82291.service-now.com/api/now/table/incident";
		
		// Authorization
		RestAssured.authentication = RestAssured.basic("admin", "Tuna@123");
		
		// Request Map
		Map<String, String> requestMap = new HashMap<String, String>();
		requestMap.put("category", "software");
		requestMap.put("state", "7");
		requestMap.put("sysparm_fields", "number,sys_id");
		
		// Request
		Response response = RestAssured
				.given()
				/*.param("category", "software")
				.param("state", "7")*/
				.accept(ContentType.XML)
				.params(requestMap)
				.get();
		
		response.prettyPrint();

		// Convert to Json
		XmlPath xmlPath = response.xmlPath();		
		// Pick your field
		List<String> allIncidents = xmlPath.getList("response.result.number");
		System.out.println(allIncidents.size());
		
		
		
		
		
		
	}

}
