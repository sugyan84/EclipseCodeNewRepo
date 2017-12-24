package problem.compete.Another5;

import java.util.*;
import java.io.*;

class TestClass
{
	public static void main(String args[]) throws Exception
	{

		// BufferedReader br = new BufferedReader(new
		// InputStreamReader(System.in));

		Scanner s = new Scanner(System.in);

		int T = s.nextInt();

		for(int i = 0; i < T; i++)
		{
			int num = s.nextInt();

			int[][] matrix = new int[num][num];
			
			int sum = 0;
			
			for(int r=0, c=1; c<num; r++, c++)
			{
				sum = sum+ (r+1) + (c+1) + 1;
			}
			
			for(int r=1, c=num-1; r<num-1; r++)
			{
				sum = sum+ (r+1) + (c+1) + 1;
			}
			
			int l = (num*(num+1));
			
			

			//int localSum = 0;

			
			
			System.out.println(sum+l);
		}

	}
}
