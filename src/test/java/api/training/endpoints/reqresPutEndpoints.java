package api.training.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matcher.*;

import org.testng.ITestContext;

import api.training.payloads.postRequest_POJO;
import api.training.payloads.putRequest_POJO;
import api.training.routes.routes;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.ResponseAwareMatcher.*;

public class reqresPutEndpoints {
	
	//static ITestContext context;
	
	public static Response reqresPutRequest_POJO(int id, putRequest_POJO payload) {

		
		//int u_id = (int) context.getSuite().getAttribute("id");
		int u_id = id;
		
		Response response = given()
					.contentType(ContentType.JSON)
					.accept("application/json")
					.pathParam("id", u_id)
					//.queryParam("id", u_id)
					.body(payload)
					
				.when()
					//.put(routes.reqres_putUrl);
					.patch(routes.reqres_putUrl);
		
		return response;
	}
}
