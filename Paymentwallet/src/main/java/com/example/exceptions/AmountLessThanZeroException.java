package com.example.exceptions;

public class AmountLessThanZeroException extends RuntimeException{
	
	public AmountLessThanZeroException(String msg)
	{
		super(msg);
	}
	public AmountLessThanZeroException(String msg,Throwable e){
        super(msg,e);
    }
}
