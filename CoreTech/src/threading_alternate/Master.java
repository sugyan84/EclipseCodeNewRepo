package threading_alternate;

public class Master
{
	public volatile int count=1;
	
	public synchronized void print() throws InterruptedException
	{
		while(count<=10)
		{
			Thread.sleep(999);
			while(Thread.currentThread().getName().equalsIgnoreCase("Even") && (count%2!=0) || (Thread.currentThread().getName().equalsIgnoreCase("Odd") && (count%2==0)))
			{
				wait();
			}
			
			if(count<=10)
			System.out.println(Thread.currentThread().getName()+" "+count);
			count++;
			notify();
		}
	}
}
