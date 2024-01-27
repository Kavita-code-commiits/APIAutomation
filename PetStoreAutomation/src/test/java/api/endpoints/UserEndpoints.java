package api.endpoints;
import api.payload.User;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;



public class UserEndpoints {
		

	public static Response createUser(User Payload){
		
		Response response=given().
				contentType(ContentType.JSON).
				accept(ContentType.JSON). 
				body(Payload).
				when().
				post(Routes.post_url);
				return response;
			   
	}
	
	
	public static Response readUser(String Username){
		
		Response response=given().
				contentType(ContentType.JSON).
				accept(ContentType.JSON).
				pathParam("username",Username).
				
				when().
				get(Routes.get_url);
				return response;
			   
	}
	
	public static Response updateUser(User PAyload, String Username) {
		Response response =given(). 
							contentType(ContentType.JSON). 
							accept(ContentType.JSON). 
							pathParam("username",Username).
							body(PAyload). 
							when(). 
							put(Routes.Update_url);
		
						return response;
		
		
		
	}
	
	public static Response deleteUser(String Username) {
		
		Response response =given(). 
				contentType(ContentType.JSON). 
				accept(ContentType.JSON). 
				pathParam("username", Username).
				when(). 
				delete(Routes.delete_url);

			return response;

		
		
		
	}
	
	
	
	
	
}