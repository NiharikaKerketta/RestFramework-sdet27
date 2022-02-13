package RequestChaining;

import org.testng.annotations.Test;

import PojoLibrary.PojoClass;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class PostAndDeleteWithPojo {
	@Test
	public void create() {
		PojoClass pojo = new PojoClass("ashu123", "ashu project123", "Completed", 2311);
		
		 Response res = given()
				  .body(pojo)
				 .contentType(ContentType.JSON)
				 
		 .when()
		 	.post("http://localhost:8084/addProject");
		 
		String proId = res.jsonPath().get("projectId");
		 
		 given()
		 	.pathParam("project", proId)
		 	
		 	.delete("http://localhost:8084/projects/{project}")
		 	
		 .then()
		 	.statusCode(204)
		 	.contentType(ContentType.JSON)
		 	.log().all();
		 	
		      
	}
}
