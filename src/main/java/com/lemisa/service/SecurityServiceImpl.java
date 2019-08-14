package com.lemisa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lemisa.domain.User;
import com.lemisa.repository.UserDao;
import com.lemisa.security.UserDto;

@Service("securityService")
public class SecurityServiceImpl implements SecurityService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userDao.findByUsername(userName).orElseThrow(() -> new UsernameNotFoundException(userName));
		return new UserDto(user);
	}

}
