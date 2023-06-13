package api.training.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.training.endpoints.reqresPostEndpoints;
import api.training.payloads.postRequest_JsonObject;
import io.restassured.response.Response;

public class testPostRequestByJsonObjectData {
	
	Response response;
	
	@Test
	public void testPostRequest() {
		response = reqresPostEndpoints.reqres_JsonObjectData();
		response.then().log().all();
		
		//response validations
		Assert.assertEquals(response.getStatusCode(), 201);
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 201 Created");
		Assert.assertEquals(response.getHeader("Content-Type"), "application/json; charset=utf-8");
		
		//response Data-Type validations
		Assert.assertTrue(response.jsonPath().get("id") instanceof String);
		Assert.assertTrue(response.jsonPath().get("first_name") instanceof String);
		
		//response data validations
		//Assert.assertEquals(response.jsonPath().get("id"), "14");
		Assert.assertEquals(response.jsonPath().get("first_name"), "krish");
	}
}
