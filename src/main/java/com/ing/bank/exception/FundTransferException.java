package com.ing.bank.exception;

public class FundTransferException extends RuntimeException{
	
	
	private static final long serialVersionUID = 1L;

	public FundTransferException(String message)
	{
		super(message);
	}

}
