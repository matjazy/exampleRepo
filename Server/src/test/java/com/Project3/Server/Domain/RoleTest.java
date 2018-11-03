package com.Project3.Server.Domain;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class RoleTest {
	
	Role role;
	String relevantRoleToStringValue;

	@Before
	public void initializeVariables() {
		role = new Role();
		int testInt = 0;
		String testString = "test";
		User testUser = new User();
		testUser.setId(testInt);
		testUser.setUsername(testString);
		testUser.setPassword(testString);
		testUser.setEmail(testString);
		
		Set<User> testUsers = new HashSet<>();
		testUsers.add(testUser);
		
		role.setId(testInt);
		role.setName(testString);
		role.setUsers(testUsers);
		
		relevantRoleToStringValue = String.format("id: '%s', name: '%s', users: '%s'", testInt, testString, testUsers);
	}
	
	@Test
	public void toStringTest() {
		assertEquals(relevantRoleToStringValue, role.toString());
	}
	
}
