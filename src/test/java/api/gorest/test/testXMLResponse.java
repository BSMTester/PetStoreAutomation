package api.gorest.test;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import api.gorest.endpoints.invoiceEndPoints;
import api.gorest.payloads.buyerInvoice;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class testXMLResponse {

	buyerInvoice invoicePayload;
	Logger logger;
	
	@BeforeClass
	public void setup() {
		invoicePayload = new buyerInvoice();
		
		invoicePayload.setID("14");
	}
	
	@Test(priority=1)
	public void testSingleContent() {
		Response response = invoiceEndPoints.readInvoice(this.invoicePayload.getID());
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(response.getContentType(), "application/xml");
		
		String Id = response.xmlPath().get("INVOICE.ID");
		Assert.assertEquals(Id, "14");
		Assert.assertEquals(response.xmlPath().get("INVOICE.TOTAL"), "4940.40");
		response.then().log().all(); 
	}
	
	@Test(priority=2)
	public void testInvoceData() {
		Response response = invoiceEndPoints.readInvoiceData();
		//response.then().log().all();
		
		XmlPath xmlObj = new XmlPath(response.asString());
		
		List<String> InvliceIDs = xmlObj.getList("INVOICEList.INVOICE");
		System.out.println("\n****** Invoice ID's ******");
		System.out.println("Total IDs: "+InvliceIDs.size());
		
		boolean Status = false;
		
		for(String InvliceID:InvliceIDs) {
			System.out.println(InvliceID);
			if(InvliceID.equals("15"))
				Status = true;
		}
		Assert.assertEquals(Status, true);
	}
}
