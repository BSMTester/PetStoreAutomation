package api.endpoints;

/* 
Swagger URI --> https://petstore.swagger.io

Create user(Post) : https://petstore.swagger.io/v2/user
Get user (Get): https://petstore.swagger.io/v2/user/{username}
Update user (Put) : https://petstore.swagger.io/v2/user/{username}
Delete user (Delete) : https://petstore.swagger.io/v2/user/{username}

*/

public class Routes {

	//*********** JSon Format Swagger doc **************
	public static String base_url="https://petstore.swagger.io/v2" ;
	
	//User module
	
	public static String post_url=base_url+"/user";
    public static String get_url=base_url+"/user/{username}";
    public static String update_url=base_url+"/user/{username}";
    public static String delete_url=base_url+"/user/{username}";
    
    //Store module
    
		//Here you will create Store module URL's

    //Pet module
    		//Here you will create Pet module URL's
    
    //************XML Format*************
    //BDD Routes
    //# http://thomas-bayer.com/sqlrest/CUSTOMER/15/
    public static String customer_get_url = "http://thomas-bayer.com/sqlrest/CUSTOMER/{id}";
    
}
