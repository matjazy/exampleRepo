package com.Project3.Server.REST;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.inject.Inject;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.Project3.Server.Repositories.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApplicationControllerTest {

	@Inject
	UserRepository userRepository;

	@Inject
	MockMvc mockMvc;

	JSONObject validUserJSONObject, invalidUserJSONObject;
	String validUsername;

	@Before
	public void initializeVariables() {
		validUsername = "testUser";
		String validPassword = "testPassword!1";
		String validEmail = "test@test.com";

		String invalidUsername = "";

		validUserJSONObject = new JSONObject();
		invalidUserJSONObject = new JSONObject();
		try {
			validUserJSONObject.put("username", validUsername);
			validUserJSONObject.put("password", validPassword);
			validUserJSONObject.put("email", validEmail);

			invalidUserJSONObject.put("username", invalidUsername);
			invalidUserJSONObject.put("password", validPassword);
			invalidUserJSONObject.put("email", validEmail);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testRegisterUser() {
		try {
			mockMvc.perform(post("/users").content(validUserJSONObject.toString())).andExpect(status().isOk())
					.andExpect(content().string(containsString("User registration successful.")));
			mockMvc.perform(post("/users").content(invalidUserJSONObject.toString())).andExpect(status().isBadRequest())
					.andExpect(content().string(containsString("User registration unsuccessful.")));
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	@After
	public void clearDatabase() {
		userRepository.deleteByUsername(validUsername);
	};
}