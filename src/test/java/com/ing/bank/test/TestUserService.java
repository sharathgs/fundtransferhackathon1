package com.ing.bank.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.ing.bank.dto.UserDto;
import com.ing.bank.entity.User;
import com.ing.bank.exception.FundTransferException;
import com.ing.bank.exception.UserAccountException;
import com.ing.bank.repository.UserRepository;
import com.ing.bank.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class TestUserService {
	
	@InjectMocks
	UserService userService;
	
	@Mock
	UserRepository userRepository;
	
	public User getUser()
	{
		User user = new User();
		user.setAccountNo(123456L);
		user.setBalance((double) 10000);
		user.setConfirmPassword("test@123");
		user.setEmailId("sharathgs777@gmail.com");
		user.setFirstName("sharath");
		user.setId(1L);
		user.setLastName("Kumar");
		user.setPassword("test@123");
		user.setPhoneNo(1234567890L);
		return user;
	}

	
	@Test
	public void testGetUserDetailsPositive()
	{
		User user = getUser();
		Mockito.when(userRepository.findByaccountNo(Mockito.anyLong())).thenReturn(user);
		UserDto responseUser = userService.getUserDetails(Mockito.anyLong());
		Assert.assertEquals(responseUser.getEmailId(), "sharathgs777@gmail.com");
	}
	
	@Test(expected= UserAccountException.class) 
	public void testGetUserDetailsNegative()
	{
		User user = null;
		Mockito.when(userRepository.findByaccountNo(Mockito.anyLong())).thenReturn(user);
		userService.getUserDetails(Mockito.anyLong());
	}
}
