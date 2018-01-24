package com.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.model.ErrorMessage;

@Provider
public class NoDataFoundExceptionMapper implements ExceptionMapper<NoDataFoundException>
{

	@Override
	public Response toResponse(NoDataFoundException exception)
	{
		ErrorMessage eObj = new ErrorMessage(exception.getMessage());
		
		return Response.status(Status.NOT_FOUND).entity(eObj).build();
	}

}
