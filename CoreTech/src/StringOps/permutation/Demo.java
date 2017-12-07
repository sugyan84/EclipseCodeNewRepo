package StringOps.permutation;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Demo
{

	public static void main(String[] args)
	{
		String num = "06669939";

		System.out.println(getNoOfDivisibleSubString(getPermutations(num)));

		
	}

	public static Set<Integer> getPermutations(String str)
	{
		Set<Integer> set = new HashSet<Integer>();

		for(int i = 0; i < str.length(); i++)
		{
			for(int j = i+1; j <= str.length(); j++)
			{

				String subStr = str.substring(i, j);

				//System.out.println(subStr+" "+subStr.charAt(0));
				
				if(!(subStr.length()>1 && subStr.charAt(0)=='0'))
				{
					set.add(Integer.parseInt(subStr));
				}

			}
		}

		return set;
	}

	public static int getNoOfDivisibleSubString(Set<Integer> s)
	{
		int answer = 0;

		Iterator itr = s.iterator();

		while (itr.hasNext())
		{
			
			int x = (Integer) itr.next();

			System.out.println(x);
			
			if(x%6==0)
				answer++;
		}

		return answer;
	}
}
