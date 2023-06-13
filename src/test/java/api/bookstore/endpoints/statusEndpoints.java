package api.bookstore.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.ResponseAwareMatcher.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

import api.bookstore.routes.routes;

public class statusEndpoints {
	
	public static Response getBooksStatus(String status) {
		
		Response response = given()
				.contentType(ContentType.JSON)
				.pathParam("status", status)
				
				.when()
					.get(routes.base_url);
		
		return response;
	}
}
