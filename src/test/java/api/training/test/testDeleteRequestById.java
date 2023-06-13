package api.training.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.training.endpoints.reqresDelEndpoints;
import io.restassured.response.Response;

public class testDeleteRequestById {
	Response response;
	reqresDelEndpoints delEndpoint;
	
	@BeforeClass
	public void setup() {
		delEndpoint = new reqresDelEndpoints();
	}
	
	@Test
	public void deleteRequestById() {
		response = delEndpoint.reqresDeleteById();
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 204);
		Assert.assertEquals(response.getHeader("Connection"), "keep-alive");
	}
}
