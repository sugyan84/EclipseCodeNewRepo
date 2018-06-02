package problem.randomGenerator;

import java.util.Scanner;

public class TestClass3
{
	public static void main(String[] args)
	{
		Scanner scan = new  Scanner(System.in);
		
		int TC = scan.nextInt();
		
		int N = scan.nextInt();
		
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++)
		{
			arr[i] = scan.nextInt();
		}
		
		
		System.out.println("Array is: ");
		
		for(int i=0; i<arr.length; i++)
		{
			System.out.print(arr[i]+" ");
		}
	}
}
