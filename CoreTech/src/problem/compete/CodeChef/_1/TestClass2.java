package problem.compete.CodeChef._1;

import java.util.HashMap;
import java.util.Scanner;

public class TestClass2
{

	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		
		HashMap<Integer, String> m = new HashMap();
		
		m.put(0, "Beginner");
		m.put(1, "Junior Developer");
		m.put(2, "Middle Developer");
		m.put(3, "Senior Developer");
		m.put(4, "Hacker");
		m.put(5, "Jeff Dean");
		
		int N = s.nextInt();
		
		for(int i=0; i<N; i++)
		{
			int count=0;
			
			for(int j=0; j<5; j++)
			{
				int now = s.nextInt();
				
				if(now==1)
				{
					count++;
				}
			}
			
			System.out.println(m.get(count));
		}

	}

}
