package problem.Numbers;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution
{

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int arr[] = new int[n];

		long posCount = 0;
		long negCount = 0;
		long zeroCount = 0;

		for(int arr_i = 0; arr_i < n; arr_i++)
		{
			arr[arr_i] = in.nextInt();

			if(arr[arr_i] > 0) posCount++;

			if(arr[arr_i] == 0) zeroCount++;

			if(arr[arr_i] < 0) negCount++;
		}

		double pos = (double) posCount / n;
		double neg = (double) negCount / n;
		double zero = (double) zeroCount / n;

		String str = "";

		System.out.println(pos);
		System.out.println(neg);
		System.out.println(zero);
	}
}
