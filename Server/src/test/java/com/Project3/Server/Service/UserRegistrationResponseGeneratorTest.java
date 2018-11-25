package com.Project3.Server.Service;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRegistrationResponseGeneratorTest {

	@Inject
	UserRegistrationResponseGenerator userRegistrationResponseGenerator;

	ResponseEntity<String> registrationSuccesfulResponse, registrationUnsuccessfulResponse,
			relevantRegistrationSuccessfulResponse, relevantRegistrationUnsuccessfulResponse;

	@Before
	public void initializeVariables() {
		registrationSuccesfulResponse = userRegistrationResponseGenerator.generateResponse(true);
		registrationUnsuccessfulResponse = userRegistrationResponseGenerator.generateResponse(false);

		relevantRegistrationSuccessfulResponse = ResponseEntity.status(HttpStatus.OK)
				.body("User registration successful.");
		relevantRegistrationUnsuccessfulResponse = ResponseEntity.status(HttpStatus.BAD_REQUEST)
				.body("User registration unsuccessful.");

	}

	@Test
	public void generateResponseTest() {
		assertEquals(registrationSuccesfulResponse, relevantRegistrationSuccessfulResponse);
		assertEquals(registrationUnsuccessfulResponse, relevantRegistrationUnsuccessfulResponse);
	}
}
