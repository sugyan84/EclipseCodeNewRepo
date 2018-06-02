package problem.compete.another10;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class TestClass3
{
	public static void main(String args[]) throws Exception
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());
		for (int k = 0; k < tc; k++)
		{
			String str = br.readLine();
			int n = str.length();
			int count = 0;

			int i = 0;
			int j = n - 1;
			
			while (i < j)
			{
				if(str.charAt(i) != str.charAt(j))
				{
					int minus = j - 1;
					int plus = j + 1;

					if(i < minus)
					{
						if(str.charAt(minus) == str.charAt(i)) count++;
					}
					else if(i < plus)
					{
						if(str.charAt(plus) == str.charAt(i)) count++;
					}
					else
					{
						count= Integer.MAX_VALUE;
						break;
					}
						

					if(count > 1) break;
				}
				i++;
				j--;
			}
			if(count <= 1)
				System.out.println("Yes");
			else
				System.out.println("No");
		}
	}
}
