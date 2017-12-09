package problem.hackerrankString;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution
{

	public static void main(String[] args)
	{

		char[] lookUpArr =
		{ 'h', 'a', 'c', 'k', 'e', 'r', 'r', 'a', 'n', 'k' };

		Scanner in = new Scanner(System.in);
		int q = in.nextInt();

		for(int a0 = 0; a0 < q; a0++)
		{
			String s = in.next();

			char[] sArr = s.toCharArray();

			int startStr = 0;
			int i = 0;

			for(startStr = 0; startStr < sArr.length; startStr++)
			{
				if(i == lookUpArr.length)
				{
					break;
				}
				
				if(sArr[startStr] == lookUpArr[i])
				{
					i++;
				}
			}

			if(i == lookUpArr.length)
			{
				System.out.println("YES");
			}
			else
				System.out.println("NO");

		}
	}
}