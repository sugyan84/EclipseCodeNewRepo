package problem.compete.another10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

class TestClass7
{
	static long	P;
	static long	Q;
	static long	R;
	static long	S;

	static long	d_P;
	static long	d_Q;
	static long	d_R;
	static long	d_S;

	static long	cisco_P;
	static long	cisco_Q;
	static long	cisco_R;
	static long	cisco_S;

	static long	f_P;
	static long	f_Q;
	static long	f_R;
	static long	f_S;

	private static long calculateScore(int fOrCisco)
	{
		long local_P_Score = 0;
		long local_Q_Score = 0;
		long local_R_Score = 0;
		long local_S_Score = 0;

		long retVal = 0;

		local_P_Score = calculateForProblem(fOrCisco, 'P');
		local_Q_Score = calculateForProblem(fOrCisco, 'Q');
		local_R_Score = calculateForProblem(fOrCisco, 'R');
		local_S_Score = calculateForProblem(fOrCisco, 'S');

		retVal = local_P_Score + local_Q_Score + local_R_Score + local_S_Score;

		return retVal;
	}

	private static long totalTime(int fOrCisco)
	{

		return maximum(fOrCisco);
		
	}

	private static long maximum(int i)
	{
		long retVal = 0;
		long[] a = null;

		if(i == 1)
		{
			a = new long[]
			{ f_P, f_Q, f_R, f_S };
		}
		else
		{
			a = new long[]
			{ cisco_P, cisco_Q, cisco_R, cisco_S };
		}

		Arrays.sort(a);
		retVal = a[a.length - 1];

		return retVal;
	}

	private static void whoWon()
	{
		long f_TotalScore = calculateScore(1);
		long c_TotalScore = calculateScore(2);

		/*
		 * System.out.println("F Score "+f_TotalScore);
		 * System.out.println("C Score "+c_TotalScore);
		 */

		if(f_TotalScore == c_TotalScore)
		{
			long f_TotalTime = totalTime(1);
			long c_TotalTime = totalTime(2);

			System.out.println("F_time " + f_TotalTime);
			System.out.println("C_time " + c_TotalTime);

			if(f_TotalTime == c_TotalTime)
				System.out.println("Tie");
			else if(f_TotalTime < c_TotalTime)
				System.out.println("Flash");
			else
				System.out.println("Cisco");
		}
		else if(f_TotalScore < c_TotalScore)
		{
			System.out.println("Cisco");
		}
		else
			System.out.println("Flash");
	}

	private static long calculateForProblem(int fORC, char x)
	{
		long retVal = 0;

		long currScore = 0;
		long currTime = 0;
		long who = 0;
		long reduceScore = 0;
		long mainScore = 0;

		switch (x)
		{
		case 'P':
			currScore = P;
			reduceScore = d_P;
			mainScore = P;
			if(fORC == 1)
				who = f_P;
			else
				who = cisco_P;
			break;
		case 'Q':
			currScore = Q;
			reduceScore = d_Q;
			mainScore = Q;
			if(fORC == 1)
				who = f_Q;
			else
				who = cisco_Q;
			break;
		case 'R':
			currScore = R;
			reduceScore = d_R;
			mainScore = R;
			if(fORC == 1)
				who = f_R;
			else
				who = cisco_R;
			break;
		case 'S':
			currScore = S;
			reduceScore = d_S;
			mainScore = S;
			if(fORC == 1)
				who = f_S;
			else
				who = cisco_S;
			break;

		default:
			break;
		}

		while ((currScore > mainScore / 2) && (currTime != who))
		{
			currScore = currScore - reduceScore;
			currTime++;
		}

		retVal = Long.max(mainScore / 2, currScore);

		return retVal;
	}

	public static void main(String args[]) throws Exception
	{
		// Scanner
		Scanner s = new Scanner(System.in);

		long T = s.nextLong();

		for (int i = 0; i < T; i++)
		{
			P = s.nextLong();
			Q = s.nextLong();
			R = s.nextLong();
			S = s.nextLong();

			d_P = s.nextLong();
			d_Q = s.nextLong();
			d_R = s.nextLong();
			d_S = s.nextLong();

			f_P = s.nextLong();
			f_Q = s.nextLong();
			f_R = s.nextLong();
			f_S = s.nextLong();

			cisco_P = s.nextLong();
			cisco_Q = s.nextLong();
			cisco_R = s.nextLong();
			cisco_S = s.nextLong();

			whoWon();
		}
	}
}
