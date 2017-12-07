package algos.dynamicProgramming;

public class Fibonacci_1
{

	//Dynamic Programming way
	public static int fib(int n)
    {
        /* Declare an array to store Fibonacci numbers. */
        int f[] = new int[n+1];
        int i;

        /* 0th and 1st number of the series are 0 and 1*/
        f[0] = 0;
        f[1] = 1;

        for (i = 2; i <= n; i++)
        {
           /* Add the previous 2 numbers in the series
             and store it */
            f[i] = f[i-1] + f[i-2];
        }

        return f[n];
    }
	
	
	//Recursive way
	public static int fibRecursive(int n)
	{
		if(n==0)
			return 0;
		else if(n==1)
			return 1;
		
		return fibRecursive(n-1)+fibRecursive(n-2);
	}
	
	
	
	//Traditional layman's way
	public static void fibo(int noOfElements)
	{
		int one = -1;
		int two = 1;
		int sum = 0;
		int counter = 0;

		while (true)
		{

			sum = one + two;

			System.out.println(sum);

			one = two;
			two = sum;

			counter++;

			if(counter == noOfElements+1) break;
		}
	}
	
	public static void main(String[] args)
	{
		//Dynamic Programming caller
		//System.out.println(fib(9));
		
		//Traditional layman's way
		//fibo(9);
		
		//Recursive way
		System.out.println(fibRecursive(9));
	}

}
