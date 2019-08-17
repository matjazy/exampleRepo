package com.project3.server.domain;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.project3.server.domain.Role;
import com.project3.server.domain.User;

public class UserTest {

	
	User user;
	String relevantUserToStringValue;
	
	@Before
	public void initializeVariables(){
		user = new User();
		int testInt = 0;
		String testString = "test";
		
		Role testRole = new Role();
		testRole.setId(testInt);
		testRole.setName(testString);
		Set<Role> testRoles = new HashSet<>();
		testRoles.add(testRole);
		
		user.setId(testInt);
		user.setUsername(testString);
		user.setEmail(testString);
		user.setPassword(testString);
		user.setRoles(testRoles);
		
		relevantUserToStringValue = String.format("id: '%s', username: '%s', email: '%s', password: '%s', roles: '%s'",
				testInt, testString, testString, testString, testRoles);
	}
	
	@Test
	public void toStringTest(){
		assertEquals(relevantUserToStringValue, user.toString());
	}
	
	
}
