package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndpoints1 {

	
	
		 static ResourceBundle getURL() {
				ResourceBundle routes =ResourceBundle.getBundle("routes");
				 return routes;
				
				
			}
		public static Response createUser(User payload){
			
			String post_url=getURL().getString("post_url");
			System.out.println(post_url);
			
				Response response=given().
						contentType(ContentType.JSON).
						accept(ContentType.JSON). 
						body(payload).
						when().
						post(post_url);
					return response;
					   
			}
			
			
			public static Response readUser(String Username){
				String get_url=getURL().getString("get_url");
				Response response=given().
						contentType(ContentType.JSON).
						accept(ContentType.JSON).
						pathParam("username",Username).
						
						when().
						get(get_url);
					return response;
					   
			}
			
			public static Response updateUser(User payload, String Username) {
				String update_url=getURL().getString("update_url");
				Response response =given(). 
									contentType(ContentType.JSON). 
									accept(ContentType.JSON). 
									pathParam("username",Username).
									body(payload). 
									when(). 
									put(update_url);
				
								return response;
				
				
				
			}
			
			public static Response deleteUser(String Username) {
				String delete_url=getURL().getString("delete_url");
				Response response =given(). 
						contentType(ContentType.JSON). 
						accept(ContentType.JSON). 
						pathParam("username", Username).
						when(). 
					delete(delete_url);
		
					return response;
		
				
				
				
			}
			
			
			
			
			
		
			
			
			
		}
