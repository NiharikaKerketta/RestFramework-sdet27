package practiceCRUDWithBDD;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DeleteResource {
	
	@Test
	public void delete() {
		when()
			.delete("http://localhost:8084/projects/TY_PROJ_806")
		.then()
			.assertThat().contentType(ContentType.JSON)
			.statusCode(204)
			.log().all();
			
	}
}
