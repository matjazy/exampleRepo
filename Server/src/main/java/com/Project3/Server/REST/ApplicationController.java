package com.Project3.Server.REST;

import javax.inject.Inject;

import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Project3.Server.Service.UserRegistrationResponseGenerator;
import com.Project3.Server.Service.UserRegistrator;

/**
 * Application controller providing endpoint enabling user registration. Values
 * of origins are of client module (4200 is for application run and 9876 for
 * Karma's tests).
 * 
 * @author MJazy
 *
 */
@RestController
public class ApplicationController {

	@Inject
	UserRegistrator userRegistrator;

	@Inject
	UserRegistrationResponseGenerator userRegistrationResponseGenrator;

	@PostMapping("/users")
	ResponseEntity<String> registerUser(@RequestBody String json) {
		JSONObject user = new JSONObject(json);
		return userRegistrationResponseGenrator.generateResponse(userRegistrator.registerUser(user));
	}

}
