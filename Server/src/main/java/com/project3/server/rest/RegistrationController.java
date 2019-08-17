package com.project3.server.rest;

import java.security.Principal;

import javax.inject.Inject;

import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project3.server.service.UserRegistrator;
import com.project3.server.service.UserResponseGenerator;

/**
 * Controller for user resource. It provides endpoints related to user
 * registration and login.
 * 
 * @author MJazy
 *
 */
@RestController
public class RegistrationController {

	@Inject
	UserRegistrator userRegistrator;

	@Inject
	UserResponseGenerator userResponseGenrator;

	@GetMapping("/users")
	public ResponseEntity<String> user(Principal user) {
		return userResponseGenrator.generateLoginResponse(user);
	}

	@PostMapping("/users")
	ResponseEntity<String> registerUser(@RequestBody String json) {
		JSONObject user = new JSONObject(json);
		return userResponseGenrator.generateRegistrationResponse(userRegistrator.registerUser(user));
	}

}
