package com.ing.bank.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.bank.dto.UserDto;
import com.ing.bank.entity.User;
import com.ing.bank.exception.UserAccountException;
import com.ing.bank.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	//service for user get details
	public UserDto getUserDetails(Long accountNo) throws UserAccountException
	{
		User user = userRepository.findByaccountNo(accountNo);
		logger.info("Eneterd into user service");
		if(user != null )
		{
			UserDto userDto = new UserDto();
			BeanUtils.copyProperties(user, userDto);		
			return userDto;
		}else {
			throw new UserAccountException("No user details found");
		}
	}
	
}
