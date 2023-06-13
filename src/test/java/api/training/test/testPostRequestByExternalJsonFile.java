package api.training.test;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import api.training.endpoints.reqresPostEndpoints;
import api.training.payloads.postRequest_ExternalJsonFile;
import io.restassured.response.Response;

public class testPostRequestByExternalJsonFile {
	
	Response response;
	
	@Test
	public void testpostRequestByJsonFile() throws FileNotFoundException {
		
		response = reqresPostEndpoints.reqres_ExternalJsonData();
		response.then().log().all();
		
		//response validation on status and headers, cookies
		Assert.assertEquals(response.statusCode(), 201);
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 201 Created");
		
		Assert.assertTrue(true, response.header("Content-Type"));
		Assert.assertEquals(response.header("Content-Type"), "application/json; charset=utf-8");
		//Assert.assertEquals(response.timeIn(TimeUnit.SECONDS), 200);
				
		//response body validation on data type
		Assert.assertTrue(response.jsonPath().get("id") instanceof String);
		Assert.assertTrue(response.jsonPath().get("email") instanceof String);
		
		//response body validation on data
		String id = response.jsonPath().get("id"); //get "id" from response body
		Assert.assertEquals(response.jsonPath().get("id"), id);
		Assert.assertEquals(response.jsonPath().get("first_name"), "krish");
		Assert.assertEquals(response.jsonPath().get("avatar"), "https://reqres.in/imp/faces/18-image.jpg");
		System.out.println("******** id *********"+id);
		
	}
}
