package threading_arrayAdding;

public class ArrayAddingThread extends Thread
{
	public static int[] arr;
	
	public static int startIndex=0;
	
	public static int sum=0;
	
	
	public ArrayAddingThread(int[] a)
	{
		arr=a;
	}
	public void run()
	{
		myMethod();
	}

	public synchronized void myMethod()
	{
		for(int i=1;i<=5;i++)
		{
			sum=sum+arr[startIndex];
			startIndex++;
		}
		
		System.out.println(Thread.currentThread().getName()+" -finished loop, now sum=|"+sum+"|");
	}
}
