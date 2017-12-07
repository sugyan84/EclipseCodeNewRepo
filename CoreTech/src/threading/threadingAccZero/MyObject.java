package threading.threadingAccZero;

public class MyObject
{
	String accNumber;

	public String getAccNumber()
	{
		return accNumber;
	}

	public void setAccNumber(String accNumber)
	{
		this.accNumber = accNumber;
	}

	public MyObject(String accNumber)
	{
		
		this.accNumber = accNumber;
	}

	
	public boolean isZero()
	{
		boolean status=false;
		
		char[] str= accNumber.toCharArray();
		
		for(int i=0;i<str.length;i++)
		{
			if(i+1 < str.length)
			{
				if(str[i]=='0' && str[i+1]=='0')
				{
					status= true;
					break;
				}
			}
		}
		
		
		return status;
	}
	@Override
	public String toString()
	{
		return accNumber;
	}
	
	
}
