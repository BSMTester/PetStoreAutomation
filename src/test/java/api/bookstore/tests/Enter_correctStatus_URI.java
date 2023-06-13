package api.bookstore.tests;

import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import api.bookstore.endpoints.statusEndpoints;
import io.restassured.response.Response;

public class Enter_correctStatus_URI {

	@Test
	public void p_enter_correctStatusUri() {
		
		Response response = statusEndpoints.getBooksStatus("status");
		
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
		
		Assert.assertTrue(response.getTimeIn(TimeUnit.SECONDS)<=10, "Response time is not within limit");
		
		Assert.assertTrue(true, response.getHeader("Content-Type"));
		Assert.assertEquals(response.getHeader("Content-Type"), "application/json; charset=utf-8");
		
		Assert.assertEquals(response.jsonPath().get("status"), "OK");
		Assert.assertTrue(response.jsonPath().get("status") instanceof String);
	
	}
}
