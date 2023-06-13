package api.training.test;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.training.endpoints.reqresPutEndpoints;
import api.training.payloads.putRequest_POJO;
import io.restassured.response.Response;

public class testPutRequestByPOJOClass {

	Response response;
	putRequest_POJO pojoPayload;
	Logger logger;
	String id;
	
	@BeforeClass
	public void setup(ITestContext context) {
		
		pojoPayload = new putRequest_POJO();
		
		pojoPayload.setId(154);
		pojoPayload.setFirst_name("Ramarao");
		pojoPayload.setLast_name("undamatla");
		pojoPayload.setEmail("ramarao@gmail.com");
		pojoPayload.setAvatar("https://reqres.in/imp/faces/18-image.jpg");
	}
	 
	
	@Test
	public void testputRequestpojo() {
		
		response = reqresPutEndpoints.reqresPutRequest_POJO(pojoPayload.getId(), pojoPayload);
		
		response.then().log().all();
		System.out.println("**********"+pojoPayload.getId());
		
		//validation on response status
		Assert.assertEquals(response.getStatusCode(), 200);
	
		//Assert.assertEquals(true, response.header("ContentType"));
		Assert.assertEquals(response.getHeader("Content-Type"), "application/json; charset=utf-8");
	
		Assert.assertEquals(response.jsonPath().get("id"), 154);
		Assert.assertEquals(response.jsonPath().get("email"), "ramarao@gmail.com");
		
		Assert.assertTrue(response.jsonPath().get("id") instanceof Integer);
		Assert.assertTrue(response.jsonPath().get("first_name") instanceof String);
	}
}
