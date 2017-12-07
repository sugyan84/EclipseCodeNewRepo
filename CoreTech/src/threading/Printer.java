package threading;

public class Printer
{
	static boolean even=false;
	//static int num=0;
	
	synchronized void printEven(int num)
	{
		while(!even)
		{
			//System.out.println(Thread.currentThread().getName()+" Calling wait..printEven.bcz "+even);
			try
			{
				wait();
			}
			catch(InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println(Thread.currentThread().getName()+" Even-"+num);
		even=false;
		notify();
	}
	
	synchronized void printOdd(int num)
	{
		while(even)
		{
			//System.out.println(Thread.currentThread().getName()+"Calling wait..printOdd.bcz "+even);
			try
			{
				wait();
			}
			catch(InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println(Thread.currentThread().getName()+" Odd-"+num);
		even=true;
		notify();
	}
	
}
