package com.mitocode.service;

import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.mitocode.model.Usuario;
import com.mitocode.repo.IUsuarioRepo;

public class UserService implements UserDetailsService  {

	@Autowired
	private IUsuarioRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario us = repo.findByNombre(username);
		UserDetails userDet =  (UserDetails) new User();
		return null;

}
}
