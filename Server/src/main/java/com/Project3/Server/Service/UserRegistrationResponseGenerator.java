package com.Project3.Server.Service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Service for generating response to user registering POST request.
 * 
 * @author MJazy
 *
 */
@Service("userRegistrationResponseGenerator")
public class UserRegistrationResponseGenerator {

	/**
	 * Method for generating response than can be returned to client.
	 * @param wasUserRegistrationSuccessful should be true in case user was registered, false if else.
	 * @return ResponseEntity with status and body.
	 */
	public ResponseEntity<String> generateResponse(boolean wasUserRegistrationSuccessful) {
		if (wasUserRegistrationSuccessful) {
			return ResponseEntity.status(HttpStatus.OK).body("User registration successful.");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User registration unsuccessful.");
		}
	}

}
