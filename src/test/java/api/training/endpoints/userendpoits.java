package api.training.endpoints;

import static io.restassured.RestAssured.*;
//import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.training.routes.routes;
import io.restassured.response.Response;

public class userendpoits {

	public static Response reqres_getUser(int Page) {
		
		Response response = given()
				.pathParam("page", Page)
		.when()
			.get(routes.reqres_getUrl);

		return response;
	}
}
