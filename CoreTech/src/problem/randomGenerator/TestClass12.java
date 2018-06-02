package problem.randomGenerator;

import java.util.*;

public class TestClass12
{
	public static void main(String args[]) throws Exception
	{

		System.out.println("Enter number of TCs");
		Scanner scan = new Scanner(System.in);
		int tc = scan.nextInt(); // Reading input from STDIN

		for (int i = 0; i < tc; i++)
		{
			System.out.println("Enter array size - the number of soldiers");
			/* Scanner s1 = new Scanner(System.in); */
			int N = scan.nextInt();

			int sum = 0;
			System.out.println("Enter N space-separated integers, soldier strength");

			for (int j = 0; j < N; j++)
			{
				int newInputNum = scan.nextInt();

				if(newInputNum > 0)
				{
					sum += newInputNum;
				}
			}

			do
			{
				sum = sum / 2;
				if(sum == 1)
				{
					System.out.println("Yes");
				}
				else if(sum % 2 == 0)
				{
					continue;
				}
				else
				{
					System.out.println("No");
					break;
				}
			} while (sum > 1);

		}
	}
}
