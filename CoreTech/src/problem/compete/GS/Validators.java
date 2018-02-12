package problem.compete.GS;

import java.util.Hashtable;

public class Validators
{

	public static boolean isValidOID(String str)
	{
		boolean retVal = true;
		
		char[] arr = str.toCharArray();
		
		for(char x: arr)
		{
			if(Character.isAlphabetic(x) || Character.isSpace(x) || x=='.' || x==',') {
				retVal = false;
				break;
			}
		}
		
		return retVal;
	}
	
	
	
	public static boolean isValidTimeStamp(String str)
	{
		boolean retVal = true;
		
		char[] arr = str.toCharArray();
		
		for(char x: arr)
		{
			if(Character.isAlphabetic(x) || Character.isWhitespace(x) || x=='.' ||  x==',') {
				retVal = false;
				break;
			}
		}
		
		return retVal;
	}
	
	
	public static boolean isValidSymbol(String str)
	{
		boolean retVal = true;
		
		char[] arr = str.toCharArray();
		
		for(char x: arr)
		{
			if(Character.isDigit(x) || Character.isWhitespace(x) || x=='.' ||  x==',') {
				retVal = false;
				break;
			}
		}
		
		return retVal;
	}
	
	
	public static boolean isValidOrderType(String str)
	{
		boolean retVal = false;
		
		char a = str.charAt(0);
		
		if((a=='M' || a=='L' || a=='I') && str.length()==1)
		{
			retVal = true;
		}
		return retVal;
	}
	
	
	
	public static boolean isValidOrderSide(String str)
	{
		boolean retVal = false;
		
		char a = str.charAt(0);
		
		if((a=='B' || a=='S') && str.length()==1)
		{
			retVal = true;
		}
		return retVal;
	}
	
	
	
	public static boolean isValidPrice(String str)
	{
		boolean retVal = false;
		
		
		return true;
	}
	
	
	public static boolean validateAllDetails(String queryString)
	{

		boolean retVal = true;
		String[] strSplit = null;

		// N,2,0000002,XYZ,L,B,104.53,100
		try
		{
			strSplit = queryString.split(",");

			// <Order-ID>
			int OID = -1;

			if(Validators.isValidOID(strSplit[1]))
			{
				OID = Integer.parseInt(strSplit[1]);
				
			}
			else
				throw new Exception();

			
			
			
			
			// <TimeStamp>
			long timeStamp = 0L;

			if(Validators.isValidTimeStamp(strSplit[2]))
			{
				timeStamp = Integer.parseInt(strSplit[2]);
			}
			else
				throw new Exception();

			
			
			
			
			// <Symbol>
			String symbol = null;

			if(Validators.isValidSymbol(strSplit[3]))
			{
				symbol = strSplit[3];
			}
			else
				throw new Exception();

			
			
			
			// <OrderType>
			OrderType o = null;

			if(Validators.isValidOrderType(strSplit[4]))
			{
				char x = strSplit[4].charAt(0);

				switch (x)
				{
				case 'M':
					o = OrderType.MARKET;
					break;

				case 'L':
					o = OrderType.LIMIT;
					break;
				case 'I':
					o = OrderType.IOC;
					break;
				default:
					break;
				}
			}
			else
				throw new Exception();

			
			
			
			// <OrderSide>
			OrderSide side = null;

			if(Validators.isValidOrderSide(strSplit[5]))
			{
				char x = strSplit[5].charAt(0);

				switch (x)
				{
				case 'B':
					side = OrderSide.BUY;
					break;

				case 'S':
					side = OrderSide.SELL;
					break;
				
				default: throw new Exception();
				}
			}
			else
				throw new Exception();
			
			
			
			
			// <Price>
			float p = 0.0f;
			
			if(Validators.isValidPrice(strSplit[6]))
			{
				p = Float.parseFloat(strSplit[6]);
				
			}
			else
				throw new Exception();
			
			
			
			// <Quatity>
			int q = -1;
			
			if(Validators.isValidPrice(strSplit[7]))
			{
				q =Integer.parseInt(strSplit[7]);
				
			}
			else
				throw new Exception();
			
			
			//Order newOrder = new Order(OID, timeStamp, symbol, o, side, p, q);
			
						
			retVal = true;
		}
		catch(Exception ex)
		{
			retVal = false;

		}
		finally
		{
			
		}

		return retVal;
	
	}
}
