package com.example.user.service;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.user.entity.UserEntity;

public interface UserDetailsService {
	
   UserEntity	loadByUsername(String username) throws UsernameNotFoundException;

}
