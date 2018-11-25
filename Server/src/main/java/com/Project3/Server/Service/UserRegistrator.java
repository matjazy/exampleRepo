package com.Project3.Server.Service;

import javax.inject.Inject;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.Project3.Server.Domain.User;
import com.Project3.Server.Repositories.UserRepository;

/**
 * Service for user registration.
 * @author MJazy
 *
 */
@Service("userRegistrator")
public class UserRegistrator {

	@Inject
	UserJSONParser userJSONParser;
	
	@Inject
	UserValidator userValidator;
	
	@Inject
	UserRepository userRepository;
	
	/**
	 * Method for user registration.
	 * @param jsonObject with username, password and e-mail.
	 */
	public boolean registerUser(JSONObject jsonObject) {
		User user = userJSONParser.parse(jsonObject);
		if (userValidator.isUserValid(user)) {
			userRepository.save(user);
			return true;
		}
		return false;		
	}
	
}
