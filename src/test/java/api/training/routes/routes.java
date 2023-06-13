package api.training.routes;

public class routes {

	public static String reqres_baseUrl = "https://reqres.in/api/";
	
	public static String reqres_getUrl = reqres_baseUrl+"users?page="+"{page}";
	
	public static String reqres_postUrl = reqres_baseUrl+"{myuser}";
	
	//public static String reqres_putUrl = reqres_baseUrl+"{myuser}";
	//?page={page}//id
	
	public static String reqres_putUrl = "https://reqres.in/api/users/"+"{id}";
	
	public static String reqres_delUrl = reqres_baseUrl+"{myuser}";

}
