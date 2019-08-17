package com.project3.server.repositories;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.project3.server.domain.Role;
import com.project3.server.domain.User;
import com.project3.server.repositories.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

	@Inject
	UserRepository userRepository;

	User user, user1, user2;

	@Before
	public void setupDatabase() {

		Set<Role> testRoles = new HashSet<Role>();

		user = new User();
		user1 = new User();
		user2 = new User();

		List<User> users = List.of(user, user1, user2);

		int index = 0;
		for (User user : users) {
			String userTestString = "test" + index;
			user.setUsername(userTestString);
			user.setEmail(userTestString);
			user.setPassword(userTestString);
			user.setRoles(testRoles);
			userRepository.save(user);
			index++;
		}
	}

	@Test
	public void findByUsernameTest() {
		User storedUser = userRepository.findByUsername(user.getUsername());
		User storedUser1 = userRepository.findByUsername(user1.getUsername());

		assertEquals(user.getId(), storedUser.getId());
		assertEquals(user.getUsername(), storedUser.getUsername());
		assertEquals(user.getPassword(), storedUser.getPassword());
		assertEquals(user.getEmail(), storedUser.getEmail());
		assertEquals(user.getRoles(), storedUser.getRoles());

		assertEquals(user1.getId(), storedUser1.getId());
		assertEquals(user1.getUsername(), storedUser1.getUsername());
		assertEquals(user1.getPassword(), storedUser1.getPassword());
		assertEquals(user1.getEmail(), storedUser1.getEmail());
		assertEquals(user1.getRoles(), storedUser1.getRoles());
	}

	@Test
	public void testDeleteByUsername() {

		userRepository.deleteByUsername(user2.getUsername());
		User deletedUser = userRepository.findByUsername(user2.getUsername());
		assertEquals(deletedUser, null);
	}

	@After
	public void clearDatabase() {
		userRepository.delete(user);
		userRepository.delete(user1);
		userRepository.delete(user2);
	}

}
