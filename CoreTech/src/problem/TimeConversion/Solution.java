package problem.TimeConversion;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution
{

	static String timeConversion(String s)
	{
		// Complete this function

		String[] strSplit = s.split(":");

		String half = strSplit[2].substring(strSplit[2].length() - 2);

		// System.out.println(half);

		if(half.equalsIgnoreCase("PM"))
		{
			int hh = Integer.parseInt(strSplit[0]);
			// System.out.println(hh);

			hh = hh + 12;

			if(hh < 10)
			{
				strSplit[0] = "0" + hh;
			}

			if(hh > 23)
			{
				hh = 0;
				strSplit[0] = "00";
			}
			else
			{
				strSplit[0] = String.valueOf(hh);
			}
			
			
		}
		
		strSplit[2]  = strSplit[2].substring(0, strSplit[2].length()-2);

		StringBuffer sbfr = new StringBuffer();

		for(int i = 0; i < strSplit.length; i++)
		{
			sbfr.append(strSplit[i]);

			if(i != strSplit.length - 1) sbfr.append(":");
		}

		return sbfr.toString();
	}

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		String s = in.next();
		String result = timeConversion(s);
		System.out.println(result);
	}
}
