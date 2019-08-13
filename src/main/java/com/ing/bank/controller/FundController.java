package com.ing.bank.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.ing.bank.dto.FundTransferDto;
import com.ing.bank.service.FundService;

@RestController
@CrossOrigin(allowedHeaders = {"*","*/"}, origins = {"*","*/"})
public class FundController {
	
	@Autowired
	FundService fundService;
	
	private static final Logger logger = LoggerFactory.getLogger(FundController.class);
	
	//controller for my transactions
	@GetMapping("/mytransactions")
	public ResponseEntity<List<FundTransferDto>> getMyTransactions(@RequestParam Long accountNo)
	{
		logger.info("entered into fund controller get transaction");
		return new ResponseEntity<List<FundTransferDto>>(fundService.getTransactions(accountNo),HttpStatus.OK);
	}

}
