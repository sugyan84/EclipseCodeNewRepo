import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Demo222
{

	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		
		List<Integer> scoresList = new ArrayList<Integer>();
		
		for(int i = 0; i < n; i++)
		{
			int score = in.nextInt();
			
			if(scoresList.size() == 0 || scoresList.get(scoresList.size() - 1) != score) 
				scoresList.add(score);
		}
		
		int m = in.nextInt();
		for(int i = 0; i < m; i++)
		{
			int score = in.nextInt();
			int min = 0;
			int max = scoresList.size();
			while (max > min)
			{
				int mid = (min + max) / 2;
				if(scoresList.get(mid) <= score)
					max = mid;
				else
					min = mid + 1;
			}
			System.out.println(min + 1);
		}
	}
}