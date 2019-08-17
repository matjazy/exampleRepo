package com.project3.server.repositories;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;

import javax.inject.Inject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.project3.server.domain.Role;
import com.project3.server.domain.User;
import com.project3.server.repositories.RoleRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RoleRepositoryTest {

	@Inject
	RoleRepository roleRepository;
	
	Role role, storedRole;
	
	@Before
	public void setupDatabase() {
		
		String roleName = "testRole";
		
		role = new Role();
		role.setName(roleName);
		role.setUsers(new HashSet<User>());
		
		roleRepository.save(role);
		storedRole = roleRepository.findByName(roleName);
	}
	
	@Test
	public void findByNameTest() {
		assertEquals(role.getId(), storedRole.getId());
		assertEquals(role.getName(), storedRole.getName());
		assertEquals(role.getUsers(), storedRole.getUsers());
	}
	
	@After
	public void clearDatabase() {
		roleRepository.delete(storedRole);
	}
	
}
