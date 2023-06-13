package api.training.endpoints;

import static io.restassured.RestAssured.*;

import java.io.FileNotFoundException;
import java.util.HashMap;

import api.training.payloads.postRequest_hashMap;
import api.training.payloads.postRequest_ExternalJsonFile;
import api.training.payloads.postRequest_JsonObject;
import api.training.payloads.postRequest_POJO;
import api.training.routes.routes;
//import api.training.test.retrun;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class reqresPostEndpoints {
	postRequest_ExternalJsonFile externalfilePayload =  new postRequest_ExternalJsonFile();
	
	public static Response reqres_HashMapData() {

		/* HashMap<String, String> hm = new HashMap<String, String>();
		
		hm.put("email", "e2345@gmail.com");
		hm.put("first_name", "krish");
		hm.put("last_name", "uppala");
		hm.put("avatar", "https://reqres.in/imp/faces/14-image.jpg");
		*/
		
		// (1) using hash Map
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("myuser", "users")
				.queryParam("page", "2")
				.body(postRequest_hashMap.hashMap_data().toString())
		
		.when()
			.post(routes.reqres_postUrl);
		
		return response;
	}
	
	// (2) using JSON Object (org.JSON)
	public static Response reqres_JsonObjectData() {
		
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("myuser", "users")
				.queryParam("page", 2)
				.body(postRequest_JsonObject.jsonObject_Data().toString())
			
			.when()
				.post(routes.reqres_postUrl);
		
		return response;
	}
	
	// (3) using POJO class
	public static Response reqres_pojoClassData(postRequest_POJO payload) {
		
		Response response = given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.pathParam("myuser", "users")
					.queryParam("page", 2)
					.body(payload)
					
				.when()
					.post(routes.reqres_postUrl);
		
		return response;
	}
 
	public static Response reqres_ExternalJsonData() throws FileNotFoundException {
	
		Response response =	given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("myuser", "users")
				.queryParam("page", 2)
				.body(postRequest_ExternalJsonFile.externalJsonDataFile().toString())
			
			.when()
				.post(routes.reqres_postUrl);
		
		return response;
	}
	
}