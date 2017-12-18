package problem.compete.matrixSymmetric;

import java.util.*;

class TestClass
{

	static char[][]	matrix	= null;
	static int		N;

	public static boolean horizentalSymm()
	{
		boolean retVal = true;

		int r = 0, r1 = N - 1;

		while (r < r1 && (r < N && r1 >= 0))
		{
			for(int c = 0; c < N; c++)
			{
				if(matrix[r][c] != matrix[r1][c])
				{
					retVal = false;
					break;
				}
			}

			if(!retVal)
				break;
			
			r++;
			r1--;
		}

		return retVal;
	}

	public static boolean verticalSymm()
	{
		boolean retVal = true;

		int r = 0, r1 = N - 1;

		while (r < r1 && (r < N && r1 >= 0))
		{
			for(int c = 0; c < N; c++)
			{
				if(matrix[r][c] != matrix[r1][c])
				{
					retVal = false;
					break;
				}
			}

			if(!retVal)
				break;
			r++;
			r1--;
		}

		return retVal;
	}

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

		// Write your code here
		int T = s.nextInt();

		for(int i = 0; i < T; i++)
		{
			N = s.nextInt();

			matrix = new char[N][N];

			for(int line = 0; line < N; line++)
			{
				String string = s.nextLine();

				for(int c = 0; c < string.length(); c++)
				{
					matrix[line][c] = string.charAt(c);
				}
			}

			boolean h = horizentalSymm();

			boolean v = verticalSymm();

			if(h && v)
			{
				System.out.println("BOTH");
			}
			else if(h)
			{
				System.out.println("HORIZONTAL");
			}
			else if(v)
			{
				System.out.println("VERTICAL");
			}
			else
			{
				System.out.println("NO");
			}

		}

	}
}
