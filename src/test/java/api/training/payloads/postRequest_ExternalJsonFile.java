package api.training.payloads;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;

import io.restassured.response.Response;

public class postRequest_ExternalJsonFile {
	
	public static JSONObject externalJsonDataFile() throws FileNotFoundException {
		
		File f = new File(".//body.json");
		FileReader fr = new FileReader(f);
		JSONTokener jt = new JSONTokener(fr);
		JSONObject jo = new JSONObject(jt);
		
		return jo;
	}
}
