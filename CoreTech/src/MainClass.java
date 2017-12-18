import java.util.*;
import java.io.*;

public class MainClass
{
	public static void main(String args[]) throws Exception
	{

		// BufferedReader br = new BufferedReader(new
		// InputStreamReader(System.in));

		Scanner s = new Scanner(System.in);

		long N = s.nextLong();

		long H = s.nextLong();

		long[] arr = new long[(int) N];

		for(long i = 0; i < N; i++)
		{
			arr[(int) i] = s.nextLong();
		}

		long height = 0;

		long goal = 0;

		int day = 0;

		long oldValue = 0;
		
		long oldValueGoal = 0;

		while (true)
		{
			day++;

			height = arr[(int) ((day - 1) % N)];

			height = height + oldValue;
			
			oldValue = height;

			goal = H - day * (day + 1) / 2;

			//System.out.println(day + ", " + height + ", " + goal);

			if(height < goal)
			{
				continue;
			}
			else
				break;

		}

		System.out.println(day);

	}
}
