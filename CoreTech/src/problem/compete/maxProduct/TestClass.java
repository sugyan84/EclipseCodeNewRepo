package problem.compete.maxProduct;

import java.util.*;

class TestClass
{
	public static void main(String args[]) throws Exception
	{
		/*
		 * Sample code to perform I/O: Use either of these methods for input
		 */

		// BufferedReader
		/*
		 * BufferedReader br = new BufferedReader(new
		 * InputStreamReader(System.in)); String name = br.readLine(); //
		 * Reading input from STDIN System.out.println("Hi, " + name + "."); //
		 * Writing output to STDOUT
		 */

		// Scanner

		Scanner s = new Scanner(System.in);
		// String name = s.nextLine(); // Reading input from STDIN
		// System.out.println("Hi, " + name + "."); // Writing output to STDOUT

		long[] arr = null;

		// Write your code here
		int N = s.nextInt();

		arr = new long[N];

		for(int i = 0; i < N; i++)
		{
			arr[i] = s.nextInt();
		}

		Arrays.sort(arr);

		/*
		 * for(int i=0; i<N; i++) { System.out.println(arr[i]); }
		 */

		/*
		 * long productMax = 0;
		 * 
		 * for(int i=0; i<N-1; i++) { for(int j=i+1; j<N; j++) { long temp =
		 * arr[i] * arr[j];
		 * 
		 * if(temp > productMax) { productMax = temp; } } }
		 */

		boolean printed = false;
		int i = 0;
		for(i = N - 1; i > 0; i--)
		{
			if(arr[i] < 0 || arr[i - 1] < 0)
			{
				i = i-2;
			}
			else
			{
				System.out.println(arr[i] * arr[i-1]);
				printed = true;
				break;
			}
		}
		
		if(!printed)
			System.out.println(arr[0] * arr[1]);

	}
}
