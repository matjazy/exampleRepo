package com.project3.server.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.inject.Inject;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.project3.server.repositories.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRegistratorTest {

	@Inject
	UserRegistrator userRegistrator;

	@Inject
	UserRepository userRepository;

	JSONObject validValuesJSONObject, invalidValuesJSONObject;

	@Before
	public void initializeVariables() {
		validValuesJSONObject = new JSONObject();
		invalidValuesJSONObject = new JSONObject();

		String validUsername = "test1";
		String validPassword = "testPassword!1";
		String validEmail = "test@test.com";

		String invalidUsername = "1111";

		try {
			validValuesJSONObject.put("username", validUsername);
			validValuesJSONObject.put("password", validPassword);
			validValuesJSONObject.put("email", validEmail);

			invalidValuesJSONObject.put("username", invalidUsername);
			invalidValuesJSONObject.put("password", validPassword);
			invalidValuesJSONObject.put("email", validEmail);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void registerUserTest() {
		assertTrue(userRegistrator.registerUser(validValuesJSONObject));
		assertFalse(userRegistrator.registerUser(invalidValuesJSONObject));
	}

	@After
	public void clearDatabase() {
		userRepository.deleteByUsername("test1");
	}

}
