package com.ing.bank.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ing.bank.dto.UserDto;
import com.ing.bank.service.UserService;

@RestController
@CrossOrigin(allowedHeaders = {"*","*/"}, origins = {"*","*/"})
public class UserController {
	
	@Autowired
	UserService userService;
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	
	//controller for user get account details
	@GetMapping("/getAccountDetails")
	public ResponseEntity<UserDto> getAccountDetails(@RequestParam Long accountNo)
	{
		logger.info("Eneterd into user controller");
		return new ResponseEntity<UserDto>(userService.getUserDetails(accountNo), HttpStatus.OK);
	}

}
