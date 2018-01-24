package com.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ErrorMessage
{
	String errorMessage;

	public ErrorMessage()
	{

	}
	
	public ErrorMessage(String errorMessage)
	{
		super();
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage()
	{
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage)
	{
		this.errorMessage = errorMessage;
	}
	
	
}
