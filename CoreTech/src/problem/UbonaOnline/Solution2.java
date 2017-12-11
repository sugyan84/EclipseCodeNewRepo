package problem.UbonaOnline;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class Solution2
{

	public static long process(String s)
	{
		long retValue = 1;

		long total = 1;

		Set<Character> set = new HashSet<>();

		for(int i = 0; i < s.length(); i++)
		{
			if(isVowel(s.charAt(i)))
			{
				set.add(s.charAt(i));
			}

			if(s.charAt(i) == '_')
			{
				int localCount = set.size();

				total = total * localCount;

				set.clear();
			}
		}

		retValue = total;

		if(retValue == 0) retValue = 1;

		return retValue;
	}

	public static boolean isVowel(char x)
	{
		boolean retValue = false;

		if(x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u')
		{
			retValue = true;
		}

		return retValue;

	}

	public static void main(String args[]) throws Exception
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		// Write your code here
		for(int i = 0; i < T; i++)
		{
			String se = br.readLine().trim();

			long x = process(se);

			System.out.println(x);
		}

	}
}
