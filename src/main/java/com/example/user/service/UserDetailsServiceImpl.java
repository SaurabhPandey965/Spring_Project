package com.example.user.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.user.dao.UserDao;
import com.example.user.dto.UserDto;
import com.example.user.entity.UserEntity;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	
	@Autowired 
	private UserDao userDao;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<UserEntity> user = userDao.findByUserName(username);
	UserInfoDetails userDetails = user.map(UserInfoDetails :: new).orElseThrow(()-> new UsernameNotFoundException("user not found"));
		return userDetails;
	}
	public UserEntity createUser(UserDto userDto) {
		Optional<UserEntity> user = userDao.findByUserName(userDto.getUserName());
		if (user.isPresent()) {
			throw new RuntimeException("user already present");
		}
		ModelMapper modeMapper = new ModelMapper();
		UserEntity usr = modeMapper.map(userDto, UserEntity.class);
		usr.setPassword(passwordEncoder.encode(usr.getPassword()));
		
		return userDao.save(usr);

	}
	
	
	

}
