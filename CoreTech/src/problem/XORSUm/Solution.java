package problem.XORSUm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution
{
	static long k;

	public static void main(String[] args) throws Exception
	{
		long[] arr = null;
		long n = 0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(long i = 0; i < 2; i++)
		{
			if(i == 0)
			{
				String line = br.readLine();
				String[] strSplit = line.split(" ");

				k = Long.parseLong(strSplit[1]);
				n = Long.parseLong(strSplit[0]);
			}

			if(i == 1)
			{
				String line = br.readLine();
				String[] strSplit = line.split(" ");

				arr = new long[(int)n];
				for(long j = 0; j < strSplit.length; j++)
				{
					arr[(int)j] = Long.parseLong(strSplit[(int)j]);
				}
			}

		}

		try
		{
			process(arr);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		

	}

	public static void process(long[] arr)
	{
		long noOfSubArrays = (arr.length * (arr.length + 1) / 2);

		long[] summArr = new long[(int)noOfSubArrays];

		long localSum = 0;

		long p = 0;

		for(long i = 0; i < arr.length; i++)
		{
			for(long j = i; j < arr.length; j++)
			{
				localSum = localSum ^ arr[(int)j];

				summArr[(int)p] = localSum;
				p++;
			}

			localSum = 0;
		}

		sort(summArr);

		System.out.println(summArr[(int)k - 1]);
	}

	public static void sort(long[] arr)
	{
		quickSort(arr, 0, arr.length - 1);
	}

	public static void quickSort(long[] arr, long start, long end)
	{
		if(start >= end) return;

		long pIndex = partition(arr, start, end);

		quickSort(arr, start, pIndex - 1);

		quickSort(arr, pIndex + 1, end);
	}

	public static long partition(long[] arr, long start, long end)
	{
		long pivot = arr[(int)end];

		long pIndex = start;

		for(long i = start; i < end; i++)
		{
			if(arr[(int)i] >= pivot)
			{
				swap(arr, i, pIndex);
				pIndex++;
			}
		}

		swap(arr, pIndex, end);

		return pIndex;

	}

	public static void swap(long[] arr, long a, long b)
	{
		long temp = 0;

		temp = arr[(int)a];
		arr[(int)a] = arr[(int)b];
		arr[(int)b] = temp;
	}
}
