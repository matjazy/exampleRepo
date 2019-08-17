package com.project3.server.service;

import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.junit4.SpringRunner;

import com.project3.server.domain.User;
import com.project3.server.repositories.UserRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserDetailsServiceImplementationTest {

	@Inject
	private UserDetailsServiceImplementation userDetailsServiceImplementation;

	@Inject
	private UserRepository userRepository;

	private User user;

	@Before
	public void addUserToDatabase() {
		user = new User("Test1", "Test1", "Test1@email.com");
		userRepository.save(user);
	}

	@Test(expected = UsernameNotFoundException.class)
	public void testUserNotFoundScenario() {
		userDetailsServiceImplementation.loadUserByUsername(null);
	}

	@Test
	public void testUserFoundScenario() {
		assertNotNull(userDetailsServiceImplementation.loadUserByUsername(user.getUsername()));
	}

	@After
	public void clearDatabase() {
		userRepository.delete(user);
	}
}
