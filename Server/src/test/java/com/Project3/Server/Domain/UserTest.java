package com.Project3.Server.Domain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class UserTest {

	
	User user;
	String relevantUserToStringValue;
	
	@Before
	public void initializeVariables(){
		user = new User();
		String testString = "test";
		user.setId(0);
		user.setUsername(testString);
		user.setEmail(testString);
		user.setPassword(testString);
		
		relevantUserToStringValue = String.format("id: '%s', username: '%s', email: '%s', password: '%s'",
				0, testString, testString, testString);
	}
	
	@Test
	public void toStringTest(){
		assertEquals(relevantUserToStringValue, user.toString());
	}
	
	
}
