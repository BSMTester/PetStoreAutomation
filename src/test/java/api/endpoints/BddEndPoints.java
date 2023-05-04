package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.Response;
import api.payload.*;

public class BddEndPoints {
	
	public static Response readCustomer(String Id) {
		
		Response response = given()
					.pathParam("id", Id)
				.when()
					.get(Routes.customer_get_url);
				
		return response;
	}

}
