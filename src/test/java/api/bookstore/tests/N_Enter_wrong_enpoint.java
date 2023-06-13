package api.bookstore.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.bookstore.endpoints.statusEndpoints;
import io.restassured.response.Response;

import java.util.concurrent.TimeUnit;

public class N_Enter_wrong_enpoint {
	
	@Test
	public void test_EnterWrongEndpoint() {
	
		Response response = statusEndpoints.getBooksStatus("statu");
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 404);
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 404 Not Found");
		
		Assert.assertTrue(response.getTimeIn(TimeUnit.SECONDS)<=10);
		
		Assert.assertTrue(true, response.getHeader("Content-Type"));
		Assert.assertEquals(response.getHeader("Content-Type"), "text/html; charset=utf-8");
		
	}
}
