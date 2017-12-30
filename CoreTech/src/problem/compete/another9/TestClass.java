package problem.compete.another9;

import java.util.*;
import java.io.*;

class TestClass
{
	public static void main(String args[]) throws Exception
	{

		// BufferedReader br = new BufferedReader(new
		// InputStreamReader(System.in));

		Scanner s = new Scanner(System.in);

		int T = s.nextInt();

		for(int i = 0; i < T; i++)
		{
			int n = s.nextInt();

			int[] arr = new int[n];

			for(int j = 0; j < n; j++)
			{
				arr[j] = s.nextInt();
			}

			int sum = s.nextInt();

			String ans = null;

			int localSUm = 0;
			for(int k = 0; k < n - 1; k++)
			{
				localSUm = 0;

				if(arr[k] == sum)
				{
					ans = "YES";
					break;
				}
				else
				{
					localSUm += arr[k];
				}

				for(int l = k + 1; l < n; l++)
				{
					localSUm += arr[l];

					if(localSUm == sum)
					{
						ans = "YES";
						break;
					}
					else if(localSUm > sum)
					{
						break;
					}

				}
			}

			if(ans == null)
				System.out.println("NO");
			else if(!ans.equals("YES"))
				System.out.println("NO");
			else

				System.out.println(ans);

		}

	}
}
