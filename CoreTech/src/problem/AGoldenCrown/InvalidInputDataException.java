package problem.AGoldenCrown;

public class InvalidInputDataException extends Exception
{
	String message;

	public InvalidInputDataException(String message)
	{
		super();
		this.message = message;
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
