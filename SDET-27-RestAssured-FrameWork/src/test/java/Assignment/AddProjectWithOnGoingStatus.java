package Assignment;

import static io.restassured.RestAssured.given;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import PojoLibrary.PojoClass;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class AddProjectWithOnGoingStatus {
	@Test
	public void addSingleProject() {
		
		int randomNumber = new Random().nextInt(500);
		String proName = "deepak_pro"+randomNumber;
		PojoClass pojo = new PojoClass("deepak", proName, "On Going", 10);
	
		Response resp = given()
		.body(pojo)
		.contentType(ContentType.JSON)
	.when()
		.post("http://localhost:8084/addProject");
		String successfullMsg = resp.jsonPath().get("msg");
		String projectName = resp.jsonPath().get("projectName");
	
	Assert.assertEquals(successfullMsg, "Successfully Added");
	Assert.assertEquals(projectName, proName);
	
	resp.then()
		.assertThat().statusCode(201)
		.time(Matchers.lessThan(300L), TimeUnit.SECONDS)
		.log().all();
	}
}