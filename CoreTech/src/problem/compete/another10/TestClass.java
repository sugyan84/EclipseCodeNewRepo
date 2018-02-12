package problem.compete.another10;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TestClass
{
	static Set<Character> m = new HashSet<>();
	static int count=0;

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);

		String T = s.nextLine();

		char[] a = T.toCharArray();
		
		StringBuffer sbfr = new StringBuffer();
		
		for(int i=0; i<a.length; i++)
		{
			sbfr = new StringBuffer();
			
			for(int j=i; j<a.length; j++)
			{
				sbfr.append(a[j]);
				//System.out.println(sbfr);
				process(sbfr.toString());
			}
		}
		
		
		System.out.println(count);
		

	}

	public static void process(String localStr)
	{
		char[] arr = localStr.toCharArray();

		if(arr.length==1)
		{
			count++;
			return;
		}
		
		for (char x : arr)
		{
			m.add(x);
		}

		boolean isOddCount = (localStr.length() % 2 != 0);

		boolean allCharsSame = (m.size() == 1);

		boolean midCharDiff= false;
		
		if(isOddCount)
		{
			int midIndex = arr.length / 2;

			midCharDiff = false;

			if((arr[midIndex] != arr[midIndex + 1] && arr[midIndex] != arr[midIndex - 1]) && (m.size() == 2))
			{
				midCharDiff = true;
			}
		}

		if(allCharsSame || (isOddCount && midCharDiff))
		{
			// success
			count++;
		}
	}
}
