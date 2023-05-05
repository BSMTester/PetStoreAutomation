package api.gorest.test;

import org.json.JSONArray;
//import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.gorest.endpoints.userEndPoints;
import api.gorest.payloads.gorestUser;
import io.restassured.response.Response;

public class testJsonResponse {
	
	gorestUser userPayload;
	
	@BeforeClass
	public void setup() {
		userPayload = new gorestUser();
		
		userPayload.setId(1373968);
	}
	
   // @Test(priority=1)
	public void testSingleContent() {
		
		Response response = userEndPoints.readGorestUser(this.userPayload.getId());
		response.then().log().all();
		response.then().statusCode(200);
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.getContentType(), "application/json; charset=utf-8");
		
		Assert.assertEquals(response.jsonPath().get("id").toString(), "[1373968]");
		Assert.assertEquals(response.jsonPath().get("name").toString(), "[Pres. Hiranya Johar]");
	}

	@Test(priority=2)
	public void testGorestData() {
		Response response = userEndPoints.readGorestData();
		//response.then().log().all();
		
	 //	JSONObject jo = new JSONObject(response.asString()); if JSON Data is in JSON Object 
	 	JSONArray ja = new JSONArray(response.asString()); // if JSON Data is in JSON Array
	 	
	 	System.out.println("\n***** User Names of GoRestUser *****");
	 	
		for(int i=0;i<ja.length();i++) {
			//String Id_num = jo.getJSONArray("users").getJSONObject(i).get("id").toString();

			String u_id = ja.getJSONObject(i).get("name").toString();
			System.out.println(u_id);
		}
		
		System.out.println("\n");
	}
}
