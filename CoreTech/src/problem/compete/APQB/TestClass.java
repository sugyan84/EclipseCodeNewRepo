package problem.compete.APQB;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;

/*
 * A <= P < Q <= B value of P AND Q is maximum
 */

class TestClass
{
	public static void main(String args[]) throws Exception
	{

		Scanner s = new Scanner(System.in);
		// String name = s.nextLine(); // Reading input from STDIN
		// System.out.println("Hi, " + name + "."); // Writing output to STDOUT

		// Write your code here
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       // String name = br.readLine();               
       // System.out.println("Hi, " + name + ".");   

		int T = s.nextInt();

		for(int i = 0; i < T; i++)
		{
			String[] strSplit = br.readLine().trim().split(" ");
			int a = s.nextInt();
			BigInteger aa = new BigInteger(strSplit[0]);

			int b = s.nextInt();
			BigInteger bb = new BigInteger(strSplit[1]);

			int max = 0;
			int p = 0;
			int q = 0;

			for(int j = a; j <= b; j++)
			{
				for(int k = a; k <= b; k++)
				{
					int temp = (j & k);

					if(temp > max && (j < k))
					{
						max = temp;
						p = j;
						q = k;
					}
				}
			}

			System.out.println(max);
			// System.out.println(q);
		}
	}
}
