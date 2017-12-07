package problem.SortSumMinimal;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution
{

	public static void sortAsc(int[] a)
	{
		quickSortAsc(a, 0, a.length - 1);
	}

	public static void quickSortAsc(int[] q, int start, int end)
	{
		if(start >= end)
		{
			return;
		}

		int pIndex = partitionAsc(q, start, end);

		quickSortAsc(q, start, pIndex - 1);

		quickSortAsc(q, pIndex + 1, end);

	}

	public static int partitionAsc(int[] p, int start, int end)
	{
		int pivot = p[end];

		int pIndex = start;

		for(int i = start; i < end; i++)
		{
			if(p[i] <= pivot)
			{
				swap(p, i, pIndex);
				pIndex++;
			}
		}
		swap(p, end, pIndex);

		return pIndex;
	}

	public static void swap(int[] s, int a, int b)
	{
		int temp = 0;
		temp = s[a];
		s[a] = s[b];
		s[b] = temp;
	}

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);

		System.out.println("Enter no of elements: ");

		int n = in.nextInt();

		int[] arr = new int[n];
		int[] oldArr = new int[n];

		for(int arr_i = 0; arr_i < n; arr_i++)
		{
			arr[arr_i] = in.nextInt();
			oldArr[arr_i] = arr[arr_i];
		}

		int noOfDiff = 0;

		sortAsc(arr);

		for(int i = 0; i < arr.length; i++)
		{

			if(arr[i] != oldArr[i])
			{
				noOfDiff++;
			}
		}

		System.out.println(noOfDiff - 1);
	}
}
