package problem.compete.Fact;


import java.util.*;

import problem.AGoldenCrown.InvalidInputDataException;


class Solution 
{
    
    public static int fact(int n)
    {
        int result=1;
        
        if(n==0)
         return 1;
         
         
        if(n < 0)
        {
          try
		{
			throw new InvalidInputDataException("Negative number passed");
		}
		catch(InvalidInputDataException e)
		{
			e.printStackTrace();
		}
        }         
        
        for(int i=1; i<=n; i++)
        {
            result = result*i;
        }
        
        
        
        return result;
    }
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input */

        //BufferedReader
        /*
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT */

        //Scanner
        
        Scanner s = new Scanner(System.in);
        //String name = s.nextLine();                 // Reading input from STDIN
        //System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        

        // Write your code here
        int T = s.nextInt();
        
        for(int i=0; i<T; i++)
        {
            int n = s.nextInt();
            
            System.out.println(fact(n));
        }

    }
}
