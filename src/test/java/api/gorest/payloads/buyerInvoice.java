package api.gorest.payloads;

public class buyerInvoice {

	String ID;
	String CUSTOMERID;
	String TOTAL;
	
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getCUSTOMERID() {
		return CUSTOMERID;
	}
	public void setCUSTOMERID(String cUSTOMERID) {
		CUSTOMERID = cUSTOMERID;
	}
	public String getTOTAL() {
		return TOTAL;
	}
	public void setTOTAL(String tOTAL) {
		TOTAL = tOTAL;
	}
	
}
