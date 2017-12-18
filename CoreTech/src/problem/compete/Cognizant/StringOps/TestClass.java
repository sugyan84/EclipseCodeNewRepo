package problem.compete.Cognizant.StringOps;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TestClass
{
	static char[]	chrStr	= null;

	static String	str		= null;
	static String	fin		= null;

	public static void replaceCharAtIndex(int index, char charToBeReplacedWith)
	{
		chrStr[index] = charToBeReplacedWith;
	}

	public static void reverseSubString(int a, int b)
	{
		for(int i = a,j = b; i < j; i++, j--)
		{
			swapIndies(i, j);
		}
	}

	public static void swapIndies(int a, int b)
	{
		char temp = chrStr[a];
		chrStr[a] = chrStr[b];
		chrStr[b] = temp;
	}

	public static int noOfSameIndices()
	{
		char[] charOfStr =  str.toCharArray();
		char[] charOfFin = fin.toCharArray();
		
		int count = 0;
		
		for(int i=0, j=0; (i<charOfStr.length && j<charOfFin.length); i++, j++)
		{
			if(charOfStr[i]==charOfFin[j])
			{
				count++;
			}
		}
		
		return count;
	}

	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String S = br.readLine().trim();

		chrStr = S.toCharArray();

		// First Ops
		int Q = Integer.parseInt(br.readLine().trim());

		for(int i = 0; i < Q; i++)
		{
			String[] line = br.readLine().trim().split(" ");

			int index = Integer.parseInt(line[0]);
			index = index - 1;

			char x = line[1].charAt(0);

			replaceCharAtIndex(index, x);
		}

		str = new String(chrStr);
		

		// Second Ops
		int M = Integer.parseInt(br.readLine().trim());

		for(int i = 0; i < M; i++)
		{
			String[] line = br.readLine().trim().split(" ");

			int a = Integer.parseInt(line[0]) - 1;
			int b = Integer.parseInt(line[1]) - 1;

			reverseSubString(a, b);
		}

		fin = new String(chrStr);

		

		// third Ops

		int same = noOfSameIndices();
		
		
		System.out.println(str);
		System.out.println(fin);
		System.out.println(same);
	}
}
