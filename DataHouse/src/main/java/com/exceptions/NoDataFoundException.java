package com.exceptions;

public class NoDataFoundException extends RuntimeException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String message;
	
	public NoDataFoundException()
	{
		
	}
	
	public NoDataFoundException(String msg)
	{
		this.message = msg;
	}

	public String getMessage()
	{
		return message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}
	
	
}
