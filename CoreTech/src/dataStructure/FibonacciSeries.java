package dataStructure;

public class FibonacciSeries
{

	public static void main(String[] args)
	{
		int start=0;
		int next=1, sum=0;
		
		for(int i=1;i<=10;i++)
		{
			sum=start+next;
			
			System.out.print(sum+" ");
			
			start=next;
			next=sum;
		}

	}

}
