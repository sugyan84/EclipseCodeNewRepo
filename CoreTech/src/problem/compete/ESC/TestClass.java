package problem.compete.ESC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class TestClass
{
	static long	count		= 0;

	static long	linecount		= 0;
	
	static long	maxStreak	= 0;

	static long	maxDay		= 0;

	public static void process(String s)
	{
		char[] chrArr = s.toCharArray();

		linecount =0;
		
		for(int i = 0; i < s.length(); i++)
		{
			if(chrArr[i] == 'C' || chrArr[i] == 'c')
			{
				count++;
				linecount++;

				if(count > maxStreak)
				{
					maxStreak = count;
				}
			}
			else
			{
				if(linecount > maxDay) 
					maxDay = linecount;
				
				count = 0;
				linecount=0;
			}
		}

		if(linecount > maxDay) 
			maxDay = linecount;
	}

	public static void main(String args[]) throws Exception
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Scanner s = new Scanner(System.in);

		int N = Integer.parseInt(br.readLine());

		for(int i = 0; i < N; i++)
		{
			String today = br.readLine().trim();

			process(today);
		}

		System.out.println(maxDay + " " + maxStreak);

	}
}
