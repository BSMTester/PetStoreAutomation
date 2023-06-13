package api.training.payloads;

import java.util.HashMap;

public class postRequest_hashMap {
	
	public static HashMap<String, String> hashMap_data() {
		
		HashMap<String, String> data = new HashMap<String, String>();
		
		//data.put("id", "14");
		data.put("email", "e2345@gmail.com");
		data.put("first_name", "krish");
		data.put("last_name", "uppala");
		data.put("avatar", "https://reqres.in/imp/faces/14-image.jpg");
	
		return data;
	}
}
