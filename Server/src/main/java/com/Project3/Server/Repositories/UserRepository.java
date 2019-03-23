package com.Project3.Server.Repositories;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Project3.Server.Domain.Role;
import com.Project3.Server.Domain.User;

/**
 * Repository related to User model.
 * 
 * @author MJazy
 *
 */
@Repository("userRepository")
public interface UserRepository extends CrudRepository<User, Integer> {

	/**
	 * Allows to find particular user by username.
	 * 
	 * @param username of particular user.
	 * @return user with relevant username or null.
	 */
	User findByUsername(String username);

	/**
	 * Allows to find users by email.
	 * 
	 * @param email of a user.
	 * @return List<User> with relevant email.
	 */
	List<User> findByEmail(String email);

	/**
	 * Allows to find users by roles.
	 * 
	 * @param roles of a user.
	 * @return List<User> with relevant roles.
	 */
	List<User> findByRolesIn(Set<Role> roles);

	/**
	 * Allows to delete user by username.
	 * 
	 * @param username of user to be deleted.
	 */
	@Transactional
	public Integer deleteByUsername(String username);

}
