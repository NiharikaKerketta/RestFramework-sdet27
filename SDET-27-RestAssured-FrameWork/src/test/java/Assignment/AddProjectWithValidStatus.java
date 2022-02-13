package Assignment;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import PojoLibrary.PojoClass;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class AddProjectWithValidStatus {
	@Test
	public void  addProject() {
		int randomNumber = new Random().nextInt(500);
		String proName = "deepak_pro"+randomNumber;
		
		JSONObject jObj = new JSONObject();		
		jObj.put("createdBy", "deepak");
		jObj.put("createdOn", "10/02/2021");
		jObj.put("projectName", "deepak_pro"+ randomNumber);
		jObj.put("status", "AAA");
		jObj.put("teamSize", 10);
	
		Response resp = given()
		.body(jObj)
		.contentType(ContentType.JSON)
	.when()
		.post("http://localhost:8084/addProject");
		String successfullMsg = resp.jsonPath().get("msg");
		String projectName = resp.jsonPath().get("projectName");
	
	Assert.assertEquals(successfullMsg, "Successfully Added");
	Assert.assertEquals(projectName, proName);
	
	resp.then()
		.assertThat().statusCode(201)
		.time(Matchers.lessThan(3000L), TimeUnit.SECONDS)
		.log().all();
	}
}
