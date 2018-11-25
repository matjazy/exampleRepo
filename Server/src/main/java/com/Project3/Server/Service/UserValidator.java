package com.Project3.Server.Service;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Service;

import com.Project3.Server.Domain.User;

/**
 * Service validating if user can be registered.
 * 
 * @author MJazy
 *
 */
@Service("userValidator")
public class UserValidator {

	EmailValidator emailValidator;

	public UserValidator() {
		emailValidator = EmailValidator.getInstance();
	}

	/**
	 * User should not be blank and should not be made only of numbers.
	 * 
	 * @param user that should be validated
	 * @return true in case user is valid, false if else.
	 */
	public boolean isUserValid(User user) {
		if (isUsernameValid(user.getUsername())) {
			if (!user.getPassword().isBlank()) {
				return isEmailValid(user.getEmail());
			}
		}
		return false;
	}

	private boolean isUsernameValid(String username) {
		if (!username.isBlank()) {
			return !isNumeric(username);
		}
		return false;
	}

	private boolean isEmailValid(String email) {
		return emailValidator.isValid(email);
	}

	private boolean isNumeric(String username) {
		for (char c : username.toCharArray()) {
			if (!Character.isDigit(c)) {
				return false;
			}
		}
		return true;
	}

}
