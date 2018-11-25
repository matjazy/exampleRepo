package com.Project3.Server;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity httpSecurity) {
		try {
			httpSecurity.authorizeRequests().antMatchers("/").permitAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
