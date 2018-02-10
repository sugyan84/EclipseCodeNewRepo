package threading.pool;

public class SampleTask implements Runnable
{

	@Override
	public void run()
	{
		int sum =0;
		
		for(int i=0; i<1000; i++)
		{
			/*try
			{
				Thread.sleep(38);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}*/
			
			sum+=(i+1);
		}
		
		System.out.println(Thread.currentThread().getName()+" "+sum);
	}

}
