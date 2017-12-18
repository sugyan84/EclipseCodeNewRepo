package problem.compete.ChrPrime;

import java.util.*;
import java.io.*;

class TestClass
{

	public static boolean isPrime(int num)
	{
		int count = 0;

		boolean retVal = false;

		for(int i = 2; i < num; i++)
		{
			if(num % i == 0)
			{
				count++;
				break;
			}
		}
		if(count == 0)
		{
			retVal = true;
		}
		else
		{
			retVal = false;
		}

		if(num == 1)
		{
			retVal = false;
		}

		return retVal;
	}

	public static String process(String s)
	{
		Set<Character> distinctChar = new HashSet();

		Map<Character, Integer> m = new HashMap();

		char[] chrArr = s.toCharArray();

		for(int i = 0; i < chrArr.length; i++)
		{
			distinctChar.add(chrArr[i]);

			if(m.containsKey(chrArr[i]))
			{
				m.put(chrArr[i], m.get(chrArr[i]) + 1);
			}
			else
			{
				m.put(chrArr[i], 1);
			}
		}

		boolean dist = isPrime(distinctChar.size());

		boolean eachChr = eachCharPrime(m);

		if(dist && eachChr)
		{
			return "YES";
		}
		else
			return "NO";
	}

	public static boolean eachCharPrime(Map m)
	{
		Iterator itr = m.entrySet().iterator();

		boolean retVal = true;

		while (itr.hasNext())
		{
			Map.Entry me = (Map.Entry) itr.next();

			if(!isPrime((Integer) me.getValue()))
			{
				retVal = false;
				break;
			}
		}

		return retVal;
	}

	public static void main(String args[]) throws Exception
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Scanner s = new Scanner(System.in);

		int T = Integer.parseInt(br.readLine());

		for(int i = 0; i < T; i++)
		{
			String string = br.readLine().trim();

			System.out.println(process(string));
		}

		// System.out.println(isPrime(1));
	}
}
