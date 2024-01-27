package api.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;


import api.endpoints.UserEndpoints;
import api.payload.User;

import io.restassured.response.Response;




public class UserTest {

	
		Faker faker;
		User userPayload;
		@BeforeClass
		public void setupData() {
			userPayload= new User();
			faker= new Faker();
			userPayload.setId(faker.idNumber().hashCode());
			userPayload.setUsername(faker.name().username());
			userPayload.setFirstName(faker.name().firstName());
			userPayload.setLastName(faker.name().lastName());
			userPayload.setEmail(faker.internet().emailAddress());
			userPayload.setPassword(faker.internet().password(5,8));	
			userPayload.setPhone(faker.phoneNumber().cellPhone());
			
			
		}
@Test 
public void testPostUser() {
	Response response =UserEndpoints.createUser(userPayload);
	Assert.assertEquals(response.getStatusCode(),200);
	response.then().log().all();
	
}

@Test (priority=0)
public void testGetUserData() {
	Response response =UserEndpoints.readUser(userPayload.getUsername());
	Assert.assertEquals(response.getStatusCode(),200);
	response.then().log().all();
	
}

@Test (priority=1)
public void testUpdateUser() {
	
	userPayload.setId(faker.idNumber().hashCode());
	userPayload.setFirstName(faker.name().firstName());
	
	Response response= UserEndpoints.updateUser(userPayload, userPayload.getUsername() );
	Assert.assertEquals(response.getStatusCode(),200);
	response.then().log().all();
	
}
@Test (priority=2)
public void testDeleteUser() {
	
	Response response= UserEndpoints.deleteUser(userPayload.getUsername() );
	Assert.assertEquals(response.getStatusCode(),200);
	response.then().log().all();
	
	
	
}

	



}