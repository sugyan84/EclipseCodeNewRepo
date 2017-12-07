package threading.Problems;

public class SynchMethodsThreads
{
	public static synchronized void staticSyncMethod()
	{
		for(int i=0; i< 2000; i++)
		{
			System.out.println(Thread.currentThread().getName()+" executing - "+i);
		}
	}

	public synchronized void syncMethod()
	{
		for(int i=0; i< 2000; i++)
		{
			System.out.println(Thread.currentThread().getName()+" executing - "+i);
		}
	}
	
	public void method()
	{
		for(int i=0; i< 2000; i++)
		{
			System.out.println(Thread.currentThread().getName()+" executing - "+i);
		}
	}
}



