package com.Project3.Server.Repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.Project3.Server.Domain.Role;
import com.Project3.Server.Domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

	@Inject
	UserRepository userRepository;
	
	User user, user1;
	
	
	@Before
	public void setupDatabase() {
		
		Set<Role> testRoles = new HashSet<Role>();
		
		user = new User();
		String userTestString = "test";
		user.setUsername(userTestString);
		user.setEmail(userTestString);
		user.setPassword(userTestString);
		user.setRoles(testRoles);
		userRepository.save(user);
		
		user1 = new User();
		String user1TestString = "test1";
		user1.setUsername(user1TestString);
		user1.setEmail(user1TestString);
		user1.setPassword(user1TestString);
		user1.setRoles(testRoles);
		userRepository.save(user1);
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
	
	@After
	public void clearDatabase() {
		userRepository.delete(user);
		userRepository.delete(user1);
	}
	
}
