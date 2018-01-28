package problem.compete.samsung.monkey;

/* Read input from STDIN. Print your output to STDOUT*/

import java.io.*;
import java.util.*;

public class CandidateCode
{
	public static int minPath(int startIndex, int endIndex, int lastIndexOfArray)
	{
		int retVal =0;
		
		int ck = (endIndex-startIndex);
		
		int antick = (startIndex+1 + (lastIndexOfArray-endIndex));
		
		retVal = Math.min(ck, antick);
		
		return retVal;
		
	}
	public static void main(String args[]) throws Exception
	{

		int[] arr= null;
		
		Scanner s = new Scanner(System.in);
		
		int N = s.nextInt();
		
		arr = new int[N];
		
		for(int i=0; i<N; i++)
		{
			arr[i] = s.nextInt();
		}
		
		//int[] arr = {1,2,3,4};
		
		List<Integer> resultSet = new ArrayList<Integer>();
		
		//System.out.println("Combinations...");
		
		for(int i=0; i<arr.length; i++)
		{
			for(int j=i+1; j<arr.length; j++)
			{
				//System.out.println(arr[i]+"--"+arr[j]);
				
				//calculate Min(ck, antick)
				int d = minPath(i, j, arr.length-1);
				//System.out.println("  Min Path: "+d);
				
				//total time is d+i+j
				int totalTime = d + arr[i] + arr[j];
				//System.out.println("  Total Time: "+totalTime);
				
				//store in resultSet
				resultSet.add(totalTime);
				
			}
		}
		
		//Find max(resultSet) and it's the answer
		Collections.sort(resultSet);
		
		//System.out.println("Answer: "+resultSet.get(resultSet.size()-1));
		
		System.out.println(+resultSet.get(resultSet.size()-1));

	}
}
