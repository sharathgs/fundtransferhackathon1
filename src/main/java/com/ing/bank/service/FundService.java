package com.ing.bank.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.bank.dto.FundTransferDto;
import com.ing.bank.entity.FundTransfer;
import com.ing.bank.exception.FundTransferException;
import com.ing.bank.repository.FundRepository;

@Service
public class FundService {

	@Autowired
	FundRepository fundrepository;
	
	private static final Logger logger = LoggerFactory.getLogger(FundService.class);
	
	//service for my transactions
	public List<FundTransferDto> getTransactions(Long accountNo) throws FundTransferException
	{
		logger.info("entered into fund service get transaction");
		List<FundTransfer> fundTransfer = fundrepository.getMyTransactions(accountNo);		
		List<FundTransferDto> fundTransferDto = new ArrayList<FundTransferDto>();
		if(fundTransfer.size() != 0)
		{
			for(int i =0;i<fundTransfer.size();i++)
			{
				FundTransferDto convertedFundTransferDto = new FundTransferDto();
				BeanUtils.copyProperties(fundTransfer.get(i), convertedFundTransferDto);
				fundTransferDto.add(convertedFundTransferDto);
			}
			return fundTransferDto;
		}else
		{
			throw new FundTransferException("No data found");
		}
	}
	
}
