package problem.compete.another7;

import java.util.*;
import java.io.*;
import java.math.BigInteger;

class TestClass
{
	public static void main(String args[]) throws Exception
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Scanner s = new Scanner(System.in);

		String aStr= null;
		String bStr =null;
		
		
		try
		{
			 aStr = br.readLine();
			 bStr = br.readLine();
			
		}catch(Exception e)
		{
			br.close();
		}
		
		
		BigInteger a = new BigInteger(aStr);
		BigInteger b = new BigInteger(bStr);

		BigInteger result = a;

		BigInteger i = new BigInteger("1");

		/*while (true)
		{
			if(i.compareTo(b) == 0)
			{
				break;
			}
			else
			{
				result = result.multiply(a);
				i = i.add(BigInteger.ONE);
			}
		}
*/
		BigInteger pp = new BigInteger("1000000007");
		
		result = a.modPow(b, pp);
		
		//System.out.println(result.mod(new BigInteger("1000000007")));
		
		System.out.println(result);

	}
}
