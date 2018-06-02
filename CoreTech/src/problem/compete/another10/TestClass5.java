package problem.compete.another10;

import java.util.Scanner;

public class TestClass5
{
	static char[][]	arr	= null;

	static long		L;
	static long		R;
	static long		U;
	static long		D;

	static long		N;
	static long		M;

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		N = sc.nextLong();
		M = sc.nextLong();

		arr = new char[(int) N][(int) M];

		for (int i = 0; i < N; i++)
		{
			String str = sc.next();

			for (int j = 0; j < M; j++)
			{
				arr[i][j] = str.charAt(j);
			}
		}

		L = sc.nextLong();
		R = sc.nextLong();
		U = sc.nextLong();
		D = sc.nextLong();

		long x = sc.nextLong() - 1;
		long y = sc.nextLong() - 1;

		long Q = sc.nextLong();

		for (int p = 0; p < Q; p++)
		{
			long amount = sc.nextLong();

			System.out.println(visitHouse(x, y, amount, 0));
		}
	}

	private static long visitHouse(long r, long c, long amountLeft, int dontGo)
	{
		if(r < 0 || c < 0 || r > N - 1 || c > M - 1 || arr[(int) r][(int) c] == '#')
		{
			return 0;
		}

		if(amountLeft == 0) return 1;

		long left = 0;
		long right = 0;
		long down = 0;
		long up = 0;

		if(amountLeft >= L && dontGo != 1) 
			left = visitHouse(r, c - 1, amountLeft - L, 2);

		if(amountLeft >= R && dontGo != 2) right = visitHouse(r, c + 1, amountLeft - R, 1);

		if(amountLeft >= U && dontGo != 3) up = visitHouse(r - 1, c, amountLeft - U, 4);

		if(amountLeft >= D && dontGo != 4) down = visitHouse(r + 1, c, amountLeft - D, 3);

		return left + right + up + down + 1;
	}
}
