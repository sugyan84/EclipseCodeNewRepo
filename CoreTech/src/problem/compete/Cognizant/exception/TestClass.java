package problem.compete.Cognizant.exception;

import java.util.Scanner;
import java.lang.Exception;

class TestClass
{
	static void solve(int arr[]) throws Exception
	{
		int ans = 0;

		for(int i = 0; i < 10; i++)
			for(int j = i + 1; j < 10; j++)
				ans += arr[i] / arr[j];

		throw new MyException(ans);
	}

	public static void main(String args[])
	{
		try
		{
			Scanner in = new Scanner(System.in);
			int n = in.nextInt();
			int[] arr = new int[n];
			in.nextLine();

			for(int i = 0; i < 10; i++)
				arr[i] = Integer.parseInt(in.nextLine());

			String s = in.nextLine();
			System.out.println(s.charAt(10));

			solve(arr);
		}
		catch(ArithmeticException ae)
		{
			System.out.println("Invalid division");

		}
		catch(NumberFormatException num)
		{
			System.out.println("Format mismatch");
		}
		catch(ArrayIndexOutOfBoundsException arr)
		{
			System.out.println("Array index is invalid");
		}
		catch(StringIndexOutOfBoundsException s)
		{
			System.out.println("Index is invalid");
		}
		catch(MyException mye)
		{
			System.out.println("MyException["+mye.x+"]");
		}
		catch(Exception e)
		{
			System.out.println("Exception encountered");
		}

		finally
		{
			System.out.println("Exception Handling Completed");
		}

		// Write your code here
	}
}
// Write exception class here

class MyException extends Exception
{
	int x;

	public MyException(int p)
	{
		this.x = p;
		//System.out.println("MyException[" + this.x + "]");
	}
}