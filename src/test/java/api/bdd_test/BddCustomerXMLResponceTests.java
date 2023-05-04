package api.bdd_test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import api.endpoints.BddEndPoints;
import api.payload.BddCustomer;
import io.restassured.response.Response;

public class BddCustomerXMLResponceTests {

	BddCustomer CustomerPayload;
	public Logger logger;
	
	@BeforeClass
	public void setup() {
		
		CustomerPayload = new BddCustomer();
		
		CustomerPayload.setId("15");
		
		logger= LogManager.getLogger(this.getClass());
	}
	
	@Test(priority=1)
	public void testSingleContent() {
		
		logger.info("***********Reading customer info *********");
		Response response = BddEndPoints.readCustomer(this.CustomerPayload.getId());
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
		Assert.assertEquals(response.getContentType(), "application/xml");
		response.then().log().all();
		//String id = response.xmlPath().get("CUSOMER.ID");
		//Assert.assertEquals(id, "15");
		Assert.assertEquals(response.xmlPath().get("CUSOMER.ID"), "15");
	}
	
	@Test(priority=2)
	public void testMultipleContent() {
		Response response = BddEndPoints.readCustomer(this.CustomerPayload.getId());
		Assert.assertEquals(response.xmlPath().get("CUSTOMER.ID"), "15");
		Assert.assertEquals(response.xmlPath().get("CUSTOMER.FIRSTNAME"), "Bill");
		Assert.assertEquals(response.xmlPath().get("CUSTOMER.LASTNAME"), "Clancy");
		Assert.assertEquals(response.xmlPath().get("CUSTOMER.STREET"), "319 Upland Pl.");
		Assert.assertEquals(response.xmlPath().get("CUSTOMER.CITY"), "Seattle");
	}
	
	@Test(priority=3)
	public void testMultipleContentOneGo() {
		Response response = BddEndPoints.readCustomer(this.CustomerPayload.getId());
		Assert.assertEquals(response.xmlPath().get("CUSTOMER.text()"), "15BillClancy319 Upland Pl.Seattle");
	}
	
}
