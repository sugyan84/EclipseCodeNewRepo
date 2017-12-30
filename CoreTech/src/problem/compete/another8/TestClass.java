package problem.compete.another8;

import java.util.*;
import java.io.*;

class TestClass
{
	public static List<String> getListWithoutVowels(String s)
	{
		List<String> l = new LinkedList<>();

		char[] arr = s.toCharArray();

		StringBuffer sbfr = new StringBuffer();

		for(char x : arr)
		{

			if(x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u')
			{
				l.add(sbfr.toString());
				sbfr = new StringBuffer();
				continue;
			}
			else
			{
				sbfr.append(x);
			}
		}

		l.add(sbfr.toString());

		return l;
	}

	public static boolean isVowel(char x)
	{
		if(x == 'a' || x == 'e' || x == 'i' || x == 'o' || x == 'u')
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public static void main(String args[]) throws Exception
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// Scanner s = new Scanner(System.in);

		String[] strSplit = br.readLine().split(" ");

		String a = strSplit[0];
		String b = strSplit[1];
		
		char[] aArr = a.toCharArray();
		char[] bArr = b.toCharArray();
		
		boolean lastRowFoundOne = false;
		
		int[][] matrix = new int[aArr.length][bArr.length];
		
		for(int i=0; i<aArr.length; i++)
		{
			for(int j=0; j<bArr.length; j++)
			{
				if(aArr[i]==bArr[j] && !isVowel(aArr[i]) && !isVowel(bArr[j]))
				{
					matrix[i][j] = 1;
				}
				else
				{
					matrix[i][j] = 1;
				}
			}
		}
		
		
		
		//diagonal checks
		for(int i=0; i<aArr.length; i++)
		{
			for(int j=0; j<bArr.length; j++)
			{
				
			}
		}

	}
}
