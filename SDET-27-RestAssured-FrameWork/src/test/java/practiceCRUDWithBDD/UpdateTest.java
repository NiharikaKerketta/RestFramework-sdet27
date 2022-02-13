package practiceCRUDWithBDD;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpdateTest {
	
	@Test
	public void update() {
		
		Random ran = new Random();
		int randomNumber = ran.nextInt(500);
		
		JSONObject jObj = new JSONObject();
		jObj.put("createdBy", "Neha11123");
		jObj.put("projectName", "TYSS000"+randomNumber);
		jObj.put("status", "Created");
		jObj.put("teamSize", 288);
		
		given()
			.body(jObj)
			.contentType(ContentType.JSON)
		.when()
			.put("http://localhost:8084/projects/TY_PROJ_1402")
		.then()
			.assertThat().contentType(ContentType.JSON)
			.statusCode(200)
			.log().all();
	}
}
