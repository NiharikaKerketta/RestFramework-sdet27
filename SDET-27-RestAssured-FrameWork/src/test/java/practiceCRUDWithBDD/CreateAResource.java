package practiceCRUDWithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class CreateAResource {

	@Test
	public void create() {
		
		Random ran = new Random();
		int randomNumbmer = ran.nextInt(500);
		
		JSONObject jObj = new JSONObject();		
		jObj.put("createdBy", "Nimi23");
		jObj.put("projectName", "YSS123"+ randomNumbmer);
		jObj.put("status", "Created");
		jObj.put("teamSize", 1023);
		
		given()
			.body(jObj)
			.contentType(ContentType.JSON)
		.when()
			.post("http://localhost:8084/addProject")
		.then()
			.assertThat().contentType(ContentType.JSON)
			.statusCode(201)
			.log().all();
	}
}
  