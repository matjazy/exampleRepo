package com.Project3.Server.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity httpSecurity) {
		try {
			httpSecurity.authorizeRequests().antMatchers("/").permitAll();
			httpSecurity.authorizeRequests().antMatchers("/users").permitAll().anyRequest().anonymous();
			httpSecurity.csrf().disable();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
