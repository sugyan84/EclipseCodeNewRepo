package problem.airtel;

import java.util.*;
import java.io.*;


class TestClass 
{
	static int[] arr;
	static int evenCount=0;
	static int oddCount=0;
	static int noOfSubArrays=0;
	
	public static void incrementer(int num)
	{
		if(num%2==0)
			evenCount++;
		else
			oddCount++;
	}
	
    public static void main(String args[] ) throws Exception 
    {
        
        
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Scanner s = new Scanner(System.in);
        
        int T = s.nextInt();

        arr = new int[T];
        
        for(int i=0; i<T; i++)
        {
        	arr[i] = s.nextInt();
        }
        
        for(int i=0; i<arr.length-1; i++)
        {
        	incrementer(arr[i]);
        	
        	for(int j=i+1; j<arr.length; j++)
        	{
        		incrementer(arr[j]);
        		
        		if(evenCount==oddCount)
        		{
        			noOfSubArrays++;
        		}
        	}
        	
        	evenCount=0;
        	oddCount=0;
        	
        }
        
        System.out.println(noOfSubArrays);

    }
}
