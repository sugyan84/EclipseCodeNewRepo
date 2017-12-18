package problem.compete.hashing;


import java.util.*;


class TestClass 
{
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

        boolean[] arr = null;

        long count =0;
        
        // Write your code here
        long T = s.nextLong();
        
        for(long i=0; i<T; i++)
        {
        	count =0;
        	
        	long n = s.nextInt();
        	
        	arr = new boolean[10];
        	
        	for(int k=0; k<10; k++)
        	{
        		arr[k] = false;
        	}
        	
        	for(long j=0; j<n; j++)
        	{
        		long nowNumber = s.nextLong();
        		
        		int index = (int) nowNumber % 10;
        		
        		if(arr[index])
        		{
        			count++;
        		}
        		else
        		{
        			arr[index] = true;
        		}
        	}
        	
        	System.out.println(count);
        }
    }
}
