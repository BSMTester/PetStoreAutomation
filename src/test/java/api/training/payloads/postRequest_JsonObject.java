package api.training.payloads;

import org.json.JSONObject;

public class postRequest_JsonObject {
	
	public static JSONObject jsonObject_Data() {
		
		JSONObject jo = new JSONObject();
		
		//jo.put("id", "14");
		jo.put("email", "e2345@gmail.com");
		jo.put("first_name", "krish");
		jo.put("last_name", "uppala");	
		jo.put("avatar", "https://reqres.in/imp/faces/14-image.jpg");
			
		return jo;
	}

}
