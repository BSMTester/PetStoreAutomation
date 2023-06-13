package api.training.test;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.training.endpoints.reqresPostEndpoints;
import api.training.payloads.postRequest_POJO;
import io.restassured.response.Response;

public class testPostRequestByPojoClassData {

	Response response;
	postRequest_POJO pojo_data;
	
	@BeforeClass
	public void setup() {
		
		pojo_data = new postRequest_POJO();
		pojo_data.setId(245);
		pojo_data.setFirst_name("krish");
		pojo_data.setLast_name("uppala");
		pojo_data.setEmail("e2345@gmail.com");
		pojo_data.setAvatar("https://reqres.in/imp/faces/14-image.jpg");
	}
	
	@Test
	public void reqresPostRequest(ITestContext context) {
		response = reqresPostEndpoints.reqres_pojoClassData(pojo_data);
		
		int cid = response.jsonPath().get("id");
		context.getSuite().setAttribute("user_id", cid);

		response.then().log().all();
		System.out.println("->->->->->-->"+cid);
		 
		 
		//response validation
		Assert.assertEquals(response.getStatusCode(), 201);
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 201 Created");
		Assert.assertEquals(response.header("Content-Type"), "application/json; charset=utf-8");
		
		//response json data type validation
		Assert.assertTrue(response.jsonPath().get("id") instanceof Integer);
		Assert.assertTrue(response.jsonPath().get("last_name") instanceof String);
		Assert.assertTrue(response.jsonPath().get("first_name") instanceof String);
		
		//response json data validation
		Assert.assertEquals(response.jsonPath().get("first_name"), "krish");
		Assert.assertEquals(response.jsonPath().get("last_name"), "uppala");
	}
}
