package threading.pool;

import java.util.Queue;

public class SingleThread extends Thread
{
	volatile Queue<Runnable>	taskQueue;
	String			singleThreadName;
	boolean			isStopped	= false;

	public SingleThread(Queue taskCollectorArea, String nameOfThread)
	{
		this.taskQueue = taskCollectorArea;
		this.singleThreadName = nameOfThread;
		this.setName(nameOfThread);
	}

	@Override
	public void run()
	{
		while (!isStopped)
		{

			Runnable r = taskQueue.poll();

			if(r != null)
			{
				System.out.println(this.singleThreadName + " collected new Task");

				r.run();
				
				try
				{
					Thread.sleep(1000);
				}
				catch(InterruptedException e)
				{
					e.printStackTrace();
				}
			}

		}
	}
	
	
	public void stopThread()
	{
		this.isStopped = true;
	}
}
