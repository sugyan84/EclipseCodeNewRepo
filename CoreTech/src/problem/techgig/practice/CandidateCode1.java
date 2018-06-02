package problem.techgig.practice;

/* Read input from STDIN. Print your output to STDOUT*/

import java.io.*;
import java.util.*;

public class CandidateCode1
{
	public static void main(String args[]) throws Exception
	{

		Scanner s = new Scanner(System.in);
		
		int N   = s.nextInt();
		
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++)
		{
			arr[i] = s.nextInt();
		}
		
		Arrays.sort(arr);
		
		System.out.println(arr[arr.length-1]-arr[0]);

	}
}
