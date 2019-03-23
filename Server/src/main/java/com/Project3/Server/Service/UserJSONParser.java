package com.Project3.Server.Service;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.Project3.Server.Domain.User;

/**
 * Service for parsing JSONObject to User.
 * @author MJazy
 *
 */
@Service("userJSONParser")
public class UserJSONParser {

	/**
	 * Method for parsing JSONObject to User.
	 * @param jsonObject containing relevant username, password and email.
	 * @return User with relevant values.
	 */
	public User parse(JSONObject jsonObject) {
		return new User(jsonObject.get("username").toString(), jsonObject.get("password").toString(), jsonObject.get("email").toString());
	}	
}
