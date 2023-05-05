package api.gorest.endpoints;

import static io.restassured.RestAssured.*;
//import static io.restassured.matcher.ResponseAwareMatcher.*;
//import static org.hamcrest.Matcher.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class invoiceEndPoints {

	public static Response readInvoice(String Id) {
		
		Response response = given()
					.contentType(ContentType.XML)
					.pathParam("id", Id)
					
				.when()
					.get(Routes.get_invoice_url);
		
		return response;
				
	}
	
	public static Response readInvoiceData() {
		
		Response response = given()
		
				.when()
					.get(Routes.get_invliceData);
		
		return response;
	}
}
