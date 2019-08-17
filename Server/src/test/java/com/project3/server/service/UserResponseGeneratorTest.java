package com.project3.server.service;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.project3.server.domain.User;
import com.project3.server.repositories.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserResponseGeneratorTest {

	@Inject
	UserResponseGenerator responseGenerator;

	@Inject
	UserRepository userRepository;

	User user;

	@Before
	public void addUserToDatabase() {
		user = new User("testUsername", "testPassword", "test@test.com");
		userRepository.save(user);
	}

	@Test
	public void generateRegistrationResponseTest() {
		ResponseEntity<String> actualRegistrationSuccessfulResponse = responseGenerator
				.generateRegistrationResponse(true);
		ResponseEntity<String> expectedRegistrationSuccessfulResponse = ResponseEntity.status(HttpStatus.OK)
				.body("User registration successful.");
		assertEquals(actualRegistrationSuccessfulResponse, expectedRegistrationSuccessfulResponse);
	}

	@Test
	public void testUnsuccessfulRegistrationResponse() {
		ResponseEntity<String> actualRegistrationUnsuccessfulResponse = responseGenerator
				.generateRegistrationResponse(false);
		ResponseEntity<String> expectedRegistrationUnsuccessfulResponse = ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body("User registration unsuccessful.");
		assertEquals(actualRegistrationUnsuccessfulResponse, expectedRegistrationUnsuccessfulResponse);

	}

	@Test
	public void testLoginSuccessfulResponse() {
		ResponseEntity<String> actualLoginResponse = responseGenerator.generateLoginResponse(null);
		ResponseEntity<String> expectedLoginResponse = ResponseEntity.status(HttpStatus.OK).body("Login successful.");
		assertEquals(actualLoginResponse, expectedLoginResponse);
	}

	@After
	public void clearDatabase() {
		userRepository.delete(user);
	}
}
