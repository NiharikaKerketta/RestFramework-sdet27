package parametersAndAuthentication;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PathAndQuerryParameters {
	
	@Test
	public void params() {
		given()
			.pathParam("username", "nik123")
			.queryParam("type", "member")
			.queryParam("direction", "full_name")
		.when()
			.get("https://api.github.com/users/{username}/repos")
		.then()
			.assertThat().contentType(ContentType.JSON)
			.log().all();
	}
}
