package com.Project3.Server.Service;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.Project3.Server.Domain.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserJSONParserTest {

	
	@Inject
	UserJSONParser userJSONParser;
	
	User user;
	String testString;
	
	@Before
	public void initializeVariables() {
		JSONObject jsonObject = new JSONObject();		
		testString = "test";

		try {
			jsonObject.put("username", testString);
			jsonObject.put("password", testString);
			jsonObject.put("email", testString);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		user = userJSONParser.parse(jsonObject);
		
	}
	
	@Test
	public void parseTest() {
		assertEquals(user.getUsername(), testString);
		assertEquals(user.getPassword(), testString);
		assertEquals(user.getEmail(), testString);

	}
	
}
