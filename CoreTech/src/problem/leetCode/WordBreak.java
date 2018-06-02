package problem.leetCode;

import java.util.ArrayList;
import java.util.List;

public class WordBreak
{
	static List<String> wordDict;
	static int space=1;
	
	public static boolean wordBreak(String s, List<String> wordDictParam)
	{
		boolean retVal = false;

		wordDict = wordDictParam;
		
		retVal = isBreakable(s);
		
		return retVal;
	}

	private static boolean isBreakable(String str)
	{
		for(int k=0; k<space; k++)
		{
			System.out.print("\t");
		}
		space++;
		System.out.println("("+str+")");
		
		boolean retVal = false;

		char[] arr = str.toCharArray();
		
		StringBuffer sbfr = new StringBuffer();
		
		for(int i=0; i<arr.length; i++)
		{
			sbfr.append(arr[i]);
			
			if(wordDict.contains(sbfr.toString()))	//partial words exists
			{				
				if(i!=arr.length-1)	//not the last character now.
				{
					boolean result = isBreakable(str.substring(i+1));
					
					if(result)
					{
						retVal= true;
						break;
					}
				}
				else
				{
					//word completed.
					retVal = true;
				}
				
			}
		}
		
		space--;
		for(int k=0; k<space; k++)
		{
			System.out.print("\t");
		}
		
		System.out.println("|"+retVal+"|");
		return retVal;
	}

	public static void main(String[] args)
	{
		List<String> wordDictParam = new ArrayList<String>();
		
		wordDictParam.add("leet");
		wordDictParam.add("code");
		wordDictParam.add("man");
		
		boolean r = wordBreak("leetcode", wordDictParam);
		
		System.out.println(r);
	}

}
