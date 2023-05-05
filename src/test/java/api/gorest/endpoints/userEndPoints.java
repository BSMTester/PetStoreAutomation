package api.gorest.endpoints;

import static io.restassured.RestAssured.*;
//import static io.restassured.matcher.ResponseAwareMatcher.*;
//import static org.hamcrest.Matcher.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class userEndPoints {

	public static Response readGorestUser(int Id) {
		
		Response response = given()
			.pathParam("id", Id)
			
		.when()
			.get(Routes.get_user_url);
		
		return response;
	}
	
	public static Response readGorestData() {
		
		Response response = given()
					.contentType(ContentType.JSON)
					
				.when()
					.get(Routes.get_userData_url);
		
		return response;
	}
}
