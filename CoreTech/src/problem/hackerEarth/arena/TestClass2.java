package problem.hackerEarth.arena;

import java.util.HashSet;
import java.util.Scanner;

public class TestClass2
{

	public static void main(String[] args)
	{
		 Scanner s = new Scanner(System.in);

		int N = s.nextInt();

		int K = s.nextInt();
		
		HashSet<Integer> set  =new HashSet<>();
		
		for (int i = 1; i <= N; i++)
		{
			set.add(i);
		}
		
		for(int p=0; p<K; p++)
		{
			int i = s.nextInt();
			
			int j = s.nextInt();
			
			set.remove(j);
			
		}
		
		System.out.println(set.size());

	}

}
