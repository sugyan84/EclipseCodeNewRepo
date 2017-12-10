package problem.SapientOnline;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class Solution
{

	public static boolean isPrime(int num)
	{
		if(num == 1) return false;
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

	/*
	 * public static void main(String args[]) throws Exception {
	 * 
	 * BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 * String name = br.readLine();
	 * 
	 * List<Integer> nonPrime = new ArrayList<Integer>();
	 * 
	 * List<Integer> prime = new ArrayList<Integer>();
	 * 
	 * int N = Integer.parseInt(br.readLine().trim());
	 * 
	 * String[] strSplit = br.readLine().trim().split(" ");
	 * 
	 * for(int i = 0; i < strSplit.length; i++) { int x =
	 * Integer.parseInt(strSplit[i]);
	 * 
	 * if(isPrime(x)) { // prime prime.add(x); } else { nonPrime.add(x); } }
	 * 
	 * // prime Collections.sort(prime);
	 * 
	 * // desc: nonPrime Collections.sort(nonPrime, Collections.reverseOrder());
	 * 
	 * Iterator pitr = prime.iterator();
	 * 
	 * while (pitr.hasNext()) { System.out.print(pitr.next() + " "); }
	 * 
	 * Iterator npitr = nonPrime.iterator();
	 * 
	 * while (npitr.hasNext()) { System.out.print(npitr.next() + " "); }
	 * 
	 * }
	 */

	public static void sortAsc(int[] a)
	{
		quickSortAsc(0, a.length - 1, a);
	}

	public static void quickSortAsc(int start, int end, int[] q)
	{
		if(start >= end) return;

		int pIndex = partitionAsc(start, end, q);

		quickSortAsc(start, pIndex - 1, q);

		quickSortAsc(pIndex + 1, end, q);

	}

	public static int partitionAsc(int start, int end, int[] p)
	{
		int pIndex = start;
		int pivot = p[end];

		for(int i = start; i <= end - 1; i++)
		{
			if(p[i] <= pivot)
			{
				swap(i, pIndex, p);
				pIndex++;
			}
		}

		swap(end, pIndex, p);

		return pIndex;

	}

	public static void sortDsc(int[] a)
	{
		quickSortDsc(0, a.length - 1, a);
	}

	public static void quickSortDsc(int start, int end, int[] q)
	{
		if(start >= end) return;

		int pIndex = partitionDsc(start, end, q);

		quickSortDsc(start, pIndex - 1, q);

		quickSortDsc(pIndex + 1, end, q);

	}

	public static int partitionDsc(int start, int end, int[] p)
	{
		int pIndex = start;
		int pivot = p[end];

		for(int i = start; i <= end - 1; i++)
		{
			if(p[i] >= pivot)
			{
				swap(i, pIndex, p);
				pIndex++;
			}
		}

		swap(end, pIndex, p);

		return pIndex;

	}

	public static void swap(int i, int pIndex, int[] p)
	{
		int temp = 0;
		temp = p[i];
		p[i] = p[pIndex];
		p[pIndex] = temp;
	}

	public static void main(String args[]) throws Exception
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//String name = br.readLine();

		int N = Integer.parseInt(br.readLine().trim());

		String[] strSplit = br.readLine().trim().split(" ");

		int[] intArr = new int[N];

		for(int i = 0; i < strSplit.length; i++)
		{
			intArr[i] = Integer.parseInt(strSplit[i]);

		}

		int lastPrime = 0;

		int primeEdge = 0;

		boolean swapped = true;

		for(int i = 0; i < intArr.length; i++)
		{

			swapped= false;
			
			if(!isPrime(intArr[i])) /// nonprime
			{
				// nonPrime
				for(int j = lastPrime + 1; j < N; j++)
				{
					if(isPrime(intArr[j]))
					{
						// prime
						swap(i, j, intArr);
						lastPrime = j;
						primeEdge = i;

						swapped = true;
						break;

					}
				}
			}
		}
		
		
		quickSortAsc(0, primeEdge, intArr);
		
		quickSortDsc(primeEdge+1, intArr.length-1, intArr);
		
		
		for(int k=0; k<N; k++)
		{
			System.out.println(intArr[k]+" ");
		}

	}
}
