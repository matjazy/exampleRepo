package com.project3.server.rest;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.inject.Inject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Base64Utils;

import com.project3.server.domain.User;
import com.project3.server.repositories.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

public class LoginControllerTest {

	@Inject
	UserRepository userRepository;

	@Inject
	PasswordEncoder passwordEncoder;

	@Inject
	MockMvc mockMvc;

	@Before
	public void addUserToDatabase() {
		User user = new User("testUsername", passwordEncoder.encode("testPassword"), "testEmail@email.com");
		userRepository.save(user);
	}

	@Test
	public void testSuccessfulLogin() throws Exception {
		mockMvc.perform(post("/login").header(HttpHeaders.AUTHORIZATION,
				"Basic " + Base64Utils.encodeToString("testUsername:testPassword".getBytes())))
				.andExpect(status().isOk()).andExpect(content().string(containsString("Login successful.")));
	}

	@Test
	public void testUnsuccessfulLogin() throws Exception {
		mockMvc.perform(post("/login").header(HttpHeaders.AUTHORIZATION,
				"Basic " + Base64Utils.encodeToString("t1234:test".getBytes()))).andExpect(status().isUnauthorized());
	}

	@After
	public void removeUserFromDatabase() {
		userRepository.deleteByUsername("testUsername");
	}

}
