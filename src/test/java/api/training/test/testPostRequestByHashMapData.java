package api.training.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.training.endpoints.reqresPostEndpoints;
import api.training.payloads.postRequest_hashMap;
import io.restassured.response.Response;

public class testPostRequestByHashMapData {

	Response response;
	
	@Test
	public void testPostRequest() {
	
		response = reqresPostEndpoints.reqres_HashMapData();
		response.then().log().all();
	
	//response assertion
		Assert.assertEquals(response.getStatusCode(), 201);
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 201 Created");
		Assert.assertEquals(response.getHeader("Content-Type"), "application/json; charset=utf-8");
	
	//response body data type assertion
		Assert.assertTrue(response.jsonPath().get("id") instanceof String);
		Assert.assertTrue(response.jsonPath().get("email") instanceof String);
		Assert.assertTrue(response.jsonPath().get("first_name") instanceof String);
		
	//response body data assertion
		Assert.assertEquals(response.jsonPath().get("email"), "e2345@gmail.com");
		Assert.assertEquals(response.jsonPath().get("first_name"), "krish");
		Assert.assertEquals(response.jsonPath().get("last_name"), "uppala");
		Assert.assertEquals(response.jsonPath().get("avatar"), "https://reqres.in/imp/faces/14-image.jpg");
		
	}
}
