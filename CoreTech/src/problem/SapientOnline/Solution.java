package problem.SapientOnline;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class TestClass
{

	public static boolean isPrime(int num)
	{
		if(num==1)
			return true;
		for(int i = 2; i < num; i++)
		{
			if(num % i == 0)
			{
				// System.out.println(num + " is not prime");
				return false;
			}
		}
		// System.out.println(num + " is prime");
		return true;
	}

	public static void main(String args[]) throws Exception
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name = br.readLine();

		List<Integer> nonPrime = new ArrayList<Integer>();

		List<Integer> prime = new ArrayList<Integer>();

		int N = Integer.parseInt(br.readLine().trim());

		String[] strSplit = br.readLine().trim().split(" ");

		for(int i = 0; i < strSplit.length; i++)
		{
			int x = Integer.parseInt(strSplit[i]);

			if(isPrime(x))
			{
				// prime
				prime.add(x);
			}
			else
			{
				nonPrime.add(x);
			}
		}

		// prime
		Collections.sort(prime);

		// desc: nonPrime
		Collections.sort(nonPrime, Collections.reverseOrder());

		Iterator pitr = prime.iterator();

		while (pitr.hasNext())
		{
			System.out.print(pitr.next() + " ");
		}

		Iterator npitr = nonPrime.iterator();

		while (npitr.hasNext())
		{
			System.out.print(npitr.next() + " ");
		}

	}
}
