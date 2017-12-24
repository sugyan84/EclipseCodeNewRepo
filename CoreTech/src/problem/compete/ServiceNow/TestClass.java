package problem.compete.ServiceNow;

import java.util.*;
import java.io.*;

class TestClass
{
	static int	x;
	static int	y;
	static int	l;
	static int	m;
	static int	a;
	static int	b;

	public static boolean isBottomRight()
	{
		int newX = a + l;
		int newY = b-m;

		if(a < x && b < y && newX < x && newY < y && newX >=0 && newY >=0)
		{
			return true;
		}
		else
			return false;
	}

	public static boolean isBottomLeft()
	{
		int newX = a - l;
		int newY = b - m;

		if(a < x && b < y && newX < x && newY < y && newX >=0 && newY >=0)
		{
			return true;
		}
		else
			return false;
	}

	public static boolean isTopRight()
	{
		int newX = a + l;
		int newY = b + m;

		if(a < x && b < y && newX < x && newY < y && newX >=0 && newY >=0)
		{
			return true;
		}
		else
			return false;
	}

	public static boolean isTopLeft()
	{
		int newX = a - l;
		int newY = b + m;

		if(a < x && b < y && newX < x && newY < y && newX >=0 && newY >=0)
		{
			return true;
		}
		else
			return false;
	}

	public static void main(String args[]) throws Exception
	{

		// BufferedReader br = new BufferedReader(new
		// InputStreamReader(System.in));

		Scanner s = new Scanner(System.in);

		long T = s.nextInt();

		for(long i = 0; i < T; i++)
		{
			x = s.nextInt();
			y = s.nextInt();

			l = s.nextInt();
			m = s.nextInt();

			a = s.nextInt();
			b = s.nextInt();

			if(isBottomRight())
			{
				System.out.println("bottom-right");

			}
			else if(isBottomLeft())
			{
				System.out.println("bottom-left");
			}
			else if(isTopRight())
			{
				System.out.println("top-right");
			}
			else if(isTopLeft())
			{
				System.out.println("top-left");
			}

		}

	}
}
