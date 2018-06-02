package problem.opentext;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class TestClass
{
	static int			targetLength;
	static Set<String>	allCombos	= new HashSet<String>();

	public static Set<String> getAllCombinations(int N)
	{
		tryCombination(new StringBuffer());

		return allCombos;
	}

	public static void tryCombination(StringBuffer sbfr)
	{
		/*
		 * f++;
		 * 
		 * for(int i=0; i<f; i++) { System.out.print(" "); }
		 * 
		 * System.out.println("Came with: "+sbfr);
		 */

		if(sbfr.length() == targetLength)
		{
			// add computed String to Set and return;
			allCombos.add(sbfr.toString());
			return;
		}

		char[] arr = { '(', ')' };

		for (int i = 0; i < arr.length; i++)
		{
			tryCombination(sbfr.append(arr[i]));

			sbfr.deleteCharAt(sbfr.length() - 1);
		}

		// tryCombination(sbfr.append(")"));

		return;

	}

	public static Set<String> validator(Set<String> inputSet)
	{
		Iterator itr = inputSet.iterator();

		while (itr.hasNext())
		{
			String s = (String) itr.next();

			char[] arr = s.toCharArray();

			if(arr[0] != '(' || arr[arr.length - 1] != ')')
			{
				itr.remove();
				continue;
			}

			int openCount = 0;
			int closeCount = 0;
			int openBracesCounter = 0;

			for(char x: arr)
			{
				if(x=='(') openCount++;
				else closeCount++;
			}
			
			if(openCount!=closeCount)
			{
				itr.remove();
				continue;
			}
			
			for (char x : arr)
			{
				if(x == '(')
				{
					openBracesCounter++;
				}
				else if(x == ')') openBracesCounter--;

				if(openBracesCounter < 0)
				{
					itr.remove();
					break;
				}
			}

		}

		return inputSet;
	}

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);

		int N = s.nextInt();

		System.out.println("No. of Pairs= |" + N + "|");

		targetLength = 2 * N;

		System.out.println("Target Length= |" + targetLength + "|");

		Set all_Combos = getAllCombinations(N);

		/*
		 * Iterator itr = all_Combos.iterator();
		 * 
		 * while(itr.hasNext()) { System.out.println(itr.next()); }
		 */

		Set validSet = validator(all_Combos);

		Iterator itr2 = validSet.iterator();

		while (itr2.hasNext())
		{
			System.out.println(itr2.next());
		}
	}
}
