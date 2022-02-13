package waysToPostRequest;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class CreateAResourceUsingJsonObjectTest {
	@Test
	public void create() {
		Random ran = new Random();
		int randomNumber = ran.nextInt(500);
		
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Neha999");
		jObj.put("projectName", "TYCC Kolkata");
		jObj.put("status", "Created");
		jObj.put("teamSize", 7896);
		
		given()
			.body(jObj)
			.contentType(ContentType.JSON)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.assertThat().statusCode(201)
			.contentType(ContentType.JSON)
			.log().all();
	}
}
