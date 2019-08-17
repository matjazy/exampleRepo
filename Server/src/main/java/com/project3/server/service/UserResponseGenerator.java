package com.project3.server.service;

import java.security.Principal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * Response generator for UserController.
 * 
 * @author MJazy
 *
 */
@Service("userRegistrationResponseGenerator")
public class UserResponseGenerator {

	/**
	 * Method generating response for registration attempts.
	 * 
	 * @param wasUserRegistrationSuccessful
	 * @return ResponseEntity with status 200 in case of success, 400 in other case.
	 */
	public ResponseEntity<String> generateRegistrationResponse(boolean wasUserRegistrationSuccessful) {
		if (wasUserRegistrationSuccessful) {
			return ResponseEntity.status(HttpStatus.OK).body("User registration successful.");
		} else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User registration unsuccessful.");
		}
	}

	/**
	 * Method generating response for login attempts.
	 * 
	 * @param user
	 * @return
	 */
	public ResponseEntity<String> generateLoginResponse(Principal user) {
		return ResponseEntity.status(HttpStatus.OK).body("Login successful.");
	}

}
