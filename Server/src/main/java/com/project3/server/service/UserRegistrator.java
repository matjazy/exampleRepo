package com.project3.server.service;

import javax.inject.Inject;

import org.json.JSONObject;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project3.server.domain.User;
import com.project3.server.repositories.UserRepository;

/**
 * Service for user registration.
 * 
 * @author MJazy
 *
 */
@Service("userRegistrator")
public class UserRegistrator {

	@Inject
	UserValidator userValidator;

	@Inject
	UserRepository userRepository;

	@Inject
	PasswordEncoder passwordEncoder;

	/**
	 * Method for user registration.
	 * 
	 * @param jsonObject with username, password and e-mail.
	 */
	public boolean registerUser(JSONObject jsonObject) {
		User user = createUserFromJSON(jsonObject);
		if (userValidator.isUserValid(user)) {
			userRepository.save(user);
			return true;
		}
		return false;
	}

	private User createUserFromJSON(JSONObject jsonObject) {
		return new User(jsonObject.get("username").toString(),
				passwordEncoder.encode(jsonObject.get("password").toString()), jsonObject.get("email").toString());
	}

}
