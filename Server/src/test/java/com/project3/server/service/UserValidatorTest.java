package com.project3.server.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.project3.server.domain.User;
import com.project3.server.service.UserValidator;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserValidatorTest {

	@Inject
	UserValidator userValidator;
	
	User invalidUser, invalidUser1, invalidUser2, invalidUser3, validUser, validUser1;
	
	@Before
	public void initializeVariables() {
	
		String validUsername = "testUsername";
		String validUsername1 = "testUsername1";
		String validPassword = "testPassword!1";
		String validEmail = "test@test.com";
		
		String invalidUsername = "";
		String invalidUsername1= "11111";
		String invalidPassword = "";
		String invalidEmail = "";
		
		invalidUser = new User(invalidUsername, validPassword, validEmail);
		invalidUser1 = new User(invalidUsername1, validPassword, validEmail);
		invalidUser2 = new User(validUsername, invalidPassword, validEmail);
		invalidUser3 = new User(validUsername, validPassword, invalidEmail);
		
		validUser = new User(validUsername, validPassword, validEmail);
		validUser1 = new User(validUsername1, validPassword, validEmail);		
	}
	
	@Test
	public void isUserValidTest() {
		assertFalse(userValidator.isUserValid(invalidUser));
		assertFalse(userValidator.isUserValid(invalidUser1));
		assertFalse(userValidator.isUserValid(invalidUser2));
		assertFalse(userValidator.isUserValid(invalidUser3));
		assertTrue(userValidator.isUserValid(validUser));
		assertTrue(userValidator.isUserValid(validUser1));
	}
	
}
