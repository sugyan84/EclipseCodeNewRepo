package problem.compete.another11;

import java.math.BigInteger;
import java.util.Scanner;


class TestClass2
{
    public static void main(String args[] ) throws Exception 
    {
        
        
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Scanner s = new Scanner(System.in);
        
        int T = s.nextInt();

        for(int i=0; i<T; i++)
        {
        	String N = s.next();
        	
        	System.out.println(getAnswer(new BigInteger(N)));
        }

    }
	private static BigInteger getAnswer(BigInteger n)
	{
		BigInteger count = new BigInteger("1");
		
		BigInteger startNumber = new BigInteger("3");
		
		BigInteger three = new BigInteger("3");
		
		while(true)
		{
			if(n.compareTo(startNumber)==-1)
			{
				break;
			}
			
			startNumber= startNumber.multiply(three);
			count = count.add(BigInteger.ONE);
		}
		
		return count;
	}
}

