package problem.compete.another10;

import java.util.Scanner;

public class TestClass4
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		long T = sc.nextLong();

		for (int i = 0; i < T; i++)
		{
			long N = sc.nextLong();

			long[] arr = new long[(int) N];

			long[] sumArr = new long[(int) N];

			for (int k = 0; k < N; k++)
			{
				arr[k] = sc.nextLong();

				if(k == 0)
					sumArr[k] = arr[k];
				else
					sumArr[k] = sumArr[k - 1] + arr[k];
			}

			long diffTillNow = Long.MAX_VALUE;
			int c = 0;

			for (int j = 0; j < N; j++)
			{
				long firstHalfSumTillJ = sumArr[j];

				long otherHalfSumAfterJ = sumArr[(int) (N - 1)] - sumArr[j];

				if(firstHalfSumTillJ < otherHalfSumAfterJ)
				{
					c++;
					long diff = Math.abs(otherHalfSumAfterJ - firstHalfSumTillJ);

					if(diff < diffTillNow)
					{
						diffTillNow = diff;
					}
				}
				else
					break;
			}

			if(c == 0)
				System.out.println(-1);
			else
				System.out.println(diffTillNow);
		}
	}
}
