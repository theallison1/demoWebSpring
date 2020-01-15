package com.mitocode;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.sun.xml.bind.annotation.OverrideAnnotationOf;

@Configuration
public class security  extends WebSecurityConfigurerAdapter{

	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}
	
	
	protected  void configure(AuthenticationManagerBuilder auth) throws Exception{
		
		auth
		.inMemoryAuthentication()
		.withUser("user")
		.password("123")
		.roles("USER")
		.and()
		.withUser("admin")
		.password("admin");
	}
	
	
	protected  void configure(HttpSecurity http)throws Exception {
		
		http
		.authorizeRequests()
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();
	}
	
}
