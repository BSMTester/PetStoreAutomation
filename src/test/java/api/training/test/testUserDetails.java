package api.training.test;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//import api.gorest.endpoints.userEndPoints;
import api.training.endpoints.userendpoits;
import api.training.payloads.reqres_users;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class testUserDetails {
	
	reqres_users reqres_payload;
	Response res;
	
	@BeforeClass
	public void setup() {
		reqres_payload = new reqres_users();
		reqres_payload.setPage(2);
	}
	
	
	@Test(priority = 1)
	public void testUserData() {
		Response res = userendpoits.reqres_getUser(this.reqres_payload.getPage());
	//	res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
		Assert.assertEquals(res.getStatusLine(), "HTTP/1.1 200 OK");
		Assert.assertEquals(res.getHeader("Content-Type"), "application/json; charset=utf-8");
	}
	
	@Test(priority = 2)
	public void testResponseUserData() {
		
		Response res = userendpoits.reqres_getUser(this.reqres_payload.getPage());
		
		// response data assertion
		Assert.assertEquals(res.jsonPath().get("page").toString(), "2");
		Assert.assertEquals(res.jsonPath().get("data[0].id").toString(), "7");
		Assert.assertEquals(res.jsonPath().get("data[0].first_name").toString(), "Michael");
		Assert.assertEquals(res.jsonPath().get("data[2].id").toString(), "9");
		Assert.assertEquals(res.jsonPath().get("support.url").toString(), "https://reqres.in/#support-heading");
		
		//response data type assertion
		Assert.assertTrue(res.jsonPath().get("page") instanceof Integer);
		Assert.assertTrue(res.jsonPath().get("data[0].id") instanceof Integer);
		Assert.assertTrue(res.jsonPath().get("data[0].first_name") instanceof String);
		Assert.assertTrue(res.jsonPath().get("support.url") instanceof String);
		Assert.assertTrue(res.jsonPath().get("data") instanceof Object); // this is array
		Assert.assertTrue(res.jsonPath().get("support") instanceof Object);
		
		//response schema assertion
		
		//************** https://mconverter.eu/convert/txt/json/ *******
		res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("JSON Schema.json"));
		// (or)
		res.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("JSON Schema.json"));	
	}
	
	
	@Test(priority = 3)
	public void testGetJsonfieldData() {
		
	//*********** get the particular field data from response body
		Response res1 = userendpoits.reqres_getUser(this.reqres_payload.getPage());
		JSONObject jo = new JSONObject(res1.asString());
		
		for(int i=0;i<jo.length();i++) {
			
			String user_first_name = jo.getJSONArray("data").getJSONObject(i).get("first_name").toString();
			System.out.println(user_first_name);
		}
		
		System.out.println("\n");		
	}
}

