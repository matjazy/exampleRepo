package com.project3.server.rest;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.inject.Inject;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.project3.server.repositories.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RegistrationControllerTest {

	@Inject
	UserRepository userRepository;

	@Inject
	MockMvc mockMvc;

	JSONObject userJSONObject;

	private void prepareUserJSONObject(String username) throws JSONException {
		String validPassword = "testPassword";
		String validEmail = "test@test.com";

		userJSONObject = new JSONObject();
		userJSONObject.put("username", username);
		userJSONObject.put("password", validPassword);
		userJSONObject.put("email", validEmail);

	}

	@Test
	public void testSuccessfulUserRegistration() throws Exception {
		prepareUserJSONObject("testUser");
		mockMvc.perform(post("/users").content(userJSONObject.toString())).andExpect(status().isOk())
				.andExpect(content().string(containsString("User registration successful.")));
		userRepository.deleteByUsername("testUser");
	}

	@Test
	public void testUnsuccessfulUserRegistration() throws Exception {
		prepareUserJSONObject("");
		mockMvc.perform(post("/users").content(userJSONObject.toString())).andExpect(status().isBadRequest())
				.andExpect(content().string(containsString("User registration unsuccessful.")));
	}

}