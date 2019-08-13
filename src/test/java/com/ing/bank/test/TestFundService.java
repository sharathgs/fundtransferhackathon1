package com.ing.bank.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.ing.bank.dto.FundTransferDto;
import com.ing.bank.entity.FundTransfer;
import com.ing.bank.exception.FundTransferException;
import com.ing.bank.repository.FundRepository;
import com.ing.bank.service.FundService;

@RunWith(MockitoJUnitRunner.class)
public class TestFundService {
	
	@InjectMocks
	FundService fundService;
	
	@Mock
	FundRepository fundRepository;
	
	public FundTransfer getFunds()
	{
		FundTransfer fundTransfer = new FundTransfer();
		fundTransfer.setAmount((double) 10000);
		fundTransfer.setFromAccount(201415L);
		fundTransfer.setId(1L);
		fundTransfer.setRemarks("test");
		fundTransfer.setToAccount(201516L);
		return fundTransfer;
	}
	
	public FundTransfer getFunds1()
	{
		FundTransfer fundTransfer = new FundTransfer();
		fundTransfer.setAmount((double) 10000);
		fundTransfer.setFromAccount(201415L);
		fundTransfer.setId(1L);
		fundTransfer.setRemarks("test");
		fundTransfer.setToAccount(201516L);
		return fundTransfer;
	}
	
	public FundTransfer getFunds2()
	{
		FundTransfer fundTransfer = new FundTransfer();
		fundTransfer.setAmount((double) 10000);
		fundTransfer.setFromAccount(201415L);
		fundTransfer.setId(1L);
		fundTransfer.setRemarks("test");
		fundTransfer.setToAccount(201516L);
		return fundTransfer;
	}
	
	@Test
	public void testGetMyTransactionsPositive()
	{
		List<FundTransfer> transactList = new ArrayList<FundTransfer>();
		transactList.add(getFunds());
		transactList.add(getFunds1());
		transactList.add(getFunds2());
		Mockito.when(fundRepository.getMyTransactions(Mockito.anyLong())).thenReturn(transactList);
		List<FundTransferDto> resultedList = fundService.getTransactions(Mockito.anyLong());
		Assert.assertEquals(resultedList.size(), transactList.size());
	}
	
	
	@Test(expected= FundTransferException.class) 
	public void testGetMyTransactionsNegative()
	{
		List<FundTransfer> transactList = new ArrayList<FundTransfer>();
		Mockito.when(fundRepository.getMyTransactions(Mockito.anyLong())).thenReturn(transactList);
		List<FundTransferDto> resultedList = fundService.getTransactions(Mockito.anyLong());
		Assert.assertEquals(resultedList.size(), transactList.size());
	}

}
