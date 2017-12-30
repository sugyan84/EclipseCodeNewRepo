package problem.compete.ANother10;

import java.util.HashSet;

public class TestClass
{
	static HashSet<String> set = new HashSet<>();
	
	static void crazyCalculation(String s)
	{
		int n = s.length();
		
		if(n==2)
		{
			return;
		}
		
		char[] arr = s.toCharArray();
		
		StringBuffer sbfr = new StringBuffer();
		
		for(int i=0; (i<n); i++)
		{
			sbfr.append(arr[i]);
			System.out.println(sbfr.toString());
			set.add(sbfr.toString());
			
			for(int j=i+1; j<n; j++)
			{
				sbfr.append(arr[j]);
				System.out.println(sbfr.toString());
				set.add(sbfr.toString());
				
				if(sbfr.length() >=3)
				crazyCalculation(sbfr.toString());
			}
			
			sbfr = new StringBuffer();
		}
	}
	
	
	static void initiate(String s)
	{
		//permute("", s);
		System.out.println("----------------------------------------- ");
		combo("", s);
		System.out.println("----------------------------------------- ");
	}

	static void combo(String prefix, String s)
	{
		int N = s.length();

		System.out.println(prefix);

		for(int i = 0; i < N; i++)
			combo(prefix + s.charAt(i), s.substring(i + 1));
	}

	static void permute(String prefix, String s)
	{
		int N = s.length();

		if(N == 0) System.out.println(" " + prefix);

		for(int i = 0; i < N; i++)
			permute(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1, N));
	}

	public static void main(String[] args)
	{
		String s = "574";
		//initiate(s);
		
		crazyCalculation(s);
		
		System.out.println(set.size());
	}
}
