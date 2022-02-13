package Authentication;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class OAuth2 {
	@Test
	public void auth() {
		 Response response = given()
				 .formParams("client_id", "Sdet_27")
				 .formParams("client_secret", "f004f79af05735c6d213c73e9b24814c")
				 .formParams("grant_type", "client_credentials")
				 .formParams("redirect_uri", "https://example.com")
			.when()
				.post("http://coop.apps.symfonycasts.com/token");
		 String token = response.jsonPath().get("access_token");
		 	given()
		 		.auth().oauth2(token)
		 		.pathParam("USER_ID", "2783")
		 	.when()
		 		.post("http://coop.apps.symfonycasts.com/api/{USER_ID}/barn-unlock")
		 	.then()
		 		.log().all();				
	}
}
