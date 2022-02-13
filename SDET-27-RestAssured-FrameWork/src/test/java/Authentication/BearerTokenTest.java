package Authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BearerTokenTest {
	@Test
	public void bearerAuth() {
		given()
			.auth().oauth2("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")
		.when()
			.get("https://api.github.com/user/repos")
		.then()
			.assertThat().statusCode(200)
			.log().all();
	}
}
