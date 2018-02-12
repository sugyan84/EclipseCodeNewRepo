package problem.compete.GS;

import java.util.HashSet;
import java.util.Set;

public class TestCase2
{
	static Set<Integer> set = new HashSet();
	
	static int findPossibleSmallestNumberMatchingPattern(String pattern)
	{
		int retVal = -1;

		if(pattern==null || pattern.length()==0 || pattern.isEmpty())
		{
			return retVal;
		}
		
		char[] arr = pattern.toCharArray();

		int[] resultArr = new int[pattern.length() + 1];

		int startingNum = -1;

		if(arr[0] == 'N')
		{
			startingNum = 1;
			resultArr[0] = startingNum;
			resultArr[1] = resultArr[0]+1;
			set.add(1);
			set.add(2);
		}
		else if(arr[0] == 'M')
		{
			startingNum = 2;
			resultArr[0] = startingNum;
			resultArr[1] = resultArr[0]-1;
			set.add(1);
			set.add(2);
		}

		for(int c=1; c<arr.length; c++)
		{
			if(arr[c]=='M')
			{
				resultArr[c+1] = resultArr[c]-1; //decrement on previous value.
				
			
				if(resultArr[c+1]<=0)
				{
					//calc its corrsponding valid value;
					int goodValue = calcValidValue(resultArr[c+1]);
					
					//update earliar values
					updateEarlierValues(resultArr, c+1, goodValue);
				}
			}
			else if(arr[c]=='N')
			{
				resultArr[c+1] = resultArr[c]+1; //increment on previous value.
			}
		}
		
		
		StringBuffer sbfr = new StringBuffer();
		
		for(int x: resultArr)
		{
			sbfr.append(x);
		}
		
		String numFromBuff = sbfr.toString();
		
		retVal = Integer.parseInt(numFromBuff);
		
		
		return retVal;

	}

	public static void updateEarlierValues(int[] pArr, int pos, int valToBeAdded)
	{
		for(int i=0; i<=pos; i++)
		{
			pArr[i] = pArr[i]+valToBeAdded;
		}
	}
	
	public static int calcValidValue(int negativeValue)
	{
		int goodValue = -1;
		
		if(negativeValue==0)
		{
			goodValue = 1;
		}
		else
		{
			goodValue = Math.abs(negativeValue-1);			
		}
		
		return goodValue;
	}
	
	
	public static void main(String[] args)
	{
		String pattern = "MNM";

		System.out.println(findPossibleSmallestNumberMatchingPattern(pattern));
	}
}
