package problem.MarkAndToys;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution
{

	static int maximumToys(int[] prices, int k)
	{
		// Complete this function

		Arrays.sort(prices);
		long sum = 0;
		int i = 0;

		for(i = 0; i < prices.length; i++)
		{
			sum += prices[i];

			if(sum >= k)
			{
				break;
			}
		}

		return i;
	}

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int[] prices = new int[n];
		for(int prices_i = 0; prices_i < n; prices_i++)
		{
			prices[prices_i] = in.nextInt();
		}
		int result = maximumToys(prices, k);
		System.out.println(result);
		in.close();
	}
}
