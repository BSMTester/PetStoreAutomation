package api.training.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;

import api.training.routes.routes;

public class reqresDelEndpoints {
	
	public static Response reqresDeleteById() {
		
		Response response = given()
					.contentType(ContentType.JSON)
					.pathParam("myuser", "users")
					.queryParam("id", 154)
				
				.when()
					.delete(routes.reqres_delUrl);
				
			return response;	
	}
}
