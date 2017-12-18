package problem.compete.Cognizant.schoolPrayer;

import java.util.*;
import java.io.*;

class TestClass
{
	public static void main(String args[]) throws Exception
	{

		// BufferedReader br = new BufferedReader(new
		// InputStreamReader(System.in));

		Scanner s = new Scanner(System.in);

		int T = s.nextInt();

		for(int i = 0; i < T; i++)
		{
			int N = s.nextInt();

			MyList l = new MyList();

			int sum = 0;

			for(int j = 0; j < N; j++)
			{
				int newNumber = s.nextInt();

				int retVal = l.addNode(new Node(newNumber));
				
				sum = sum+retVal;
				
				System.out.println("RetVal for adding "+newNumber+" is "+retVal+". Sum now is "+sum);
			}
			
			System.out.println(sum);
		}

	}
}
