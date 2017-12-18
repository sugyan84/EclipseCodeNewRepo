package problem.compete.subStr;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class So
{
	public static int process(String s, int k)
	{
		char[] chrArr = s.toCharArray();

		int sum = 0;

		int count = 0;

		// sb.delete(0, sb.length());

		for(int i = 0; i < chrArr.length; i++)
		{
			int x = chrArr[i];
			sum = sum + (x - 96);

			if(sum == k)
			{
				count++;
			}

			for(int j = i + 1; j < chrArr.length; j++)
			{
				int y = chrArr[j];
				sum = sum + (y - 96);

				if(sum == k)
				{
					count++;
					break;
				}
				else if(sum > k)
				{
					break;
				}
				else if(sum < k)
				{
					continue;
				}
			}

			sum = 0;
		}

		return count;
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

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Scanner s = new Scanner(System.in);
		
		//int T = s.nextInt();
		
		int T = Integer.parseInt(br.readLine());

		for(int i = 0; i < T; i++)
		{
			//int k = s.nextInt();
			
			int k = Integer.parseInt(br.readLine());

			String str = br.readLine();

			System.out.println(process(str, k));

		}

		// System.out.println(process("abcdef", 5));

	}
}
