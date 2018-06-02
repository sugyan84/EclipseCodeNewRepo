package problem.master;

public class LongestIncreasingSubSeq
{

	public static void main(String[] args)
	{
		int[] arr =
		{ 10, 9, 2, 5, 3, 7, 101, 18 };

		int[] dp = new int[arr.length];

		for (int i = 0; i < arr.length; i++)
		{
			if(i==0)
			{
				dp[0]=1;
				continue;
			}
			
			if(arr[i] >= arr[i-1])
			{
				dp[i] = dp[i-1]+1;
			}
			else
			{
				dp[i] = dp[i-1];
			}
		}
		
		System.out.println(dp[arr.length-1]);

	}

}
