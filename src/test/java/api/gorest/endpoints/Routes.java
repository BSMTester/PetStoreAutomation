package api.gorest.endpoints;

public class Routes {
	
	//***********JSON Format***************
    //https://gorest.co.in/public/v2/users?id="1373972" -->Randomly change ID
    
	public static String base_url = "https://gorest.co.in/public/v2/users?id=";
	
	public static String get_user_url = base_url+"{id}";
	
	public static String get_userData_url = "https://gorest.co.in/public/v2/users";
	
	//************XML Format*****************88
	//http://thomas-bayer.com/sqlrest/INVOICE/14/
	public static String invoice_baseurl = "http://thomas-bayer.com/sqlrest/INVOICE/";
	
	public static String get_invoice_url = invoice_baseurl + "{id}";
	
	public static String get_invliceData = "http://thomas-bayer.com/sqlrest/INVOICE/";

}
