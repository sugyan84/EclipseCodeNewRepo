package threading.pool;

public class Demo
{
	public static void main(String[] args)
	{
		MyThreadPool pool = new MyThreadPool(5);
		
		for(int i=0; i<100000; i++)
		{
			SampleTask task = new SampleTask();
			
			pool.submitTask(task);
		}
		
		pool.shutDown();
	}
}
