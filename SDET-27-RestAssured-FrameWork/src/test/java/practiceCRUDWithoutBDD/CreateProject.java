package practiceCRUDWithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateProject {
	
	@Test
	public void createProject() {
		//Step 1: create data
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Niharika204");
		jObj.put("projectName", "CSSYY");
		jObj.put("status", "Created");
		jObj.put("teamSize", 255);
		
		//Step 2: provide request specification
		RequestSpecification req = RestAssured.given();
		req.contentType(ContentType.JSON);
		req.body(jObj);
		
		//Step 3: perform the action
		Response resp = req.post("http://localhost:8084/addProject");

		//Step 4: print in console and verify
		System.out.println(resp.asString());
		System.out.println(resp.prettyPrint());
		System.out.println(resp.prettyPeek());
		System.out.println(resp.getContentType());
		System.out.println(resp.getStatusCode());
	}
	
}
