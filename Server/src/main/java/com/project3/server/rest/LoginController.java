package com.project3.server.rest;

import java.security.Principal;

import javax.inject.Inject;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project3.server.service.UserResponseGenerator;

@RestController
public class LoginController {
	@Inject
	UserResponseGenerator userResponseGenrator;

	@PostMapping("/login")
	public ResponseEntity<String> user(Principal user) {
		return userResponseGenrator.generateLoginResponse(user);
	}

}
