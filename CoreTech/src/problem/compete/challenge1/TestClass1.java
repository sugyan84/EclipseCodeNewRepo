package problem.compete.challenge1;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class TestClass1
{
	static long N;
	static long mxLen;
	
	private void calculateSolution(long[] arr)
	{
		
	}
	
	private void helper(List<Long> combinations, Set<Long> commonElements, boolean status, int currentElementIndex, long[] arr)
	{
		boolean result = false;
		boolean carryFwdStatus = false;
		
		if(currentElementIndex>=N)
			return;
		
		if(status)
		{
			result = check(commonElements, arr[currentElementIndex]);
			
			if(result)
			{
				carryFwdStatus = true;
			}
		}
		
		helper(combinations.add(arr[currentElementIndex]), Set<Integer> commonElements, boolean status, int currentElementIndex, long[] arr)
		
		helper(List<Integer> combinations, Set<Integer> commonElements, boolean status, int currentElementIndex, long[] arr)
	}
	
	

	private boolean check(Set<Long> commonElements, long l)
	{
		
		return false;
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextLong();
		
		long[] arr = new long[(int)N];
		
		for(long i=0; i<N; i++)
		{
			arr[(int)i] = sc.nextLong();
		}
		
		

	}

}
