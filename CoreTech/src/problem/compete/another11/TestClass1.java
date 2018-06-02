package problem.compete.another11;

import java.util.Scanner;

class TestClass1
{
	public static void main(String args[]) throws Exception
	{

		// BufferedReader br = new BufferedReader(new
		// InputStreamReader(System.in));

		Scanner s = new Scanner(System.in);

		int T = s.nextInt();

		for (int i = 0; i < T; i++)
		{
			int N = s.nextInt();

			int totalStrength = 0;

			for (int j = 0; j < N; j++)
			{
				int newNum = s.nextInt();

				if(newNum > 0) totalStrength += newNum;
			}
			
			int isPowOf2 = 1;
			
			if(totalStrength%2==0)
			{
				/*if(totalStrength==1) break;
				totalStrength = totalStrength/2;*/
				
				isPowOf2 =  totalStrength & (totalStrength-1);
			}
			
			if(isPowOf2==0)
				System.out.println("Yes");
			else
				System.out.println("No");
		}

	}
}
