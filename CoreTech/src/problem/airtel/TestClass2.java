package problem.airtel;

import java.util.*;
import java.io.*;


class TestClass2
{
	static int[] arr;
	static Pair[] auxArr;
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
        auxArr = new Pair[T];
        
        for(int i=0; i<T; i++)
        {
        	arr[i] = s.nextInt();
        	
        	incrementer(arr[i]);
        	
        	auxArr[i] = new Pair(evenCount, oddCount);
        }
        
        
        
        
        
        
        
        //deprecated Solution
        for(int i=0; i<arr.length-1; i++)
        {
        	/*incrementer(arr[i]);*/
        	
        	for(int j=i+1; j<arr.length; j++)
        	{       		
        		if(checkAnswer(i, j))
        		{
        			noOfSubArrays++;
        		}
        	}
        	
        }
        
        System.out.println(noOfSubArrays);

    }

	private static boolean checkAnswer(int i, int j)
	{
		boolean retVal = false;
		
		Pair p1 = null;
		Pair p2 = null;
		
		if(i==0)
		{
			p1 = auxArr[0];
			p1.evenCount=0;
			p1.oddCount=0;
		}
		else		
		p1 = auxArr[i-1];
		
		p2 = auxArr[j];
		
		if((p2.evenCount-p1.evenCount) == (p2.oddCount-p1.oddCount))
		{
			retVal = true;
		}
		
		return retVal;
	}
}


class Pair
{
	int evenCount=0;
	int oddCount=0;
	
	public Pair(int evenC, int oddC)
	{
		this.evenCount= evenC;
		this.oddCount = oddC;
	}
	
	public void incrementEvenCount()
	{
		this.evenCount++;
	}
	
	public void incrementOddCount()
	{
		this.oddCount++;
	}
}
