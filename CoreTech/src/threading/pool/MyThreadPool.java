package threading.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class MyThreadPool
{
	volatile Queue<Runnable> taskQueue;
	List<SingleThread> listOfThreads;
	
	public MyThreadPool(int sizeOfPool)
	{
		this.taskQueue = new LinkedBlockingQueue<Runnable>();
		
		this.listOfThreads = new ArrayList<>(sizeOfPool);
		
		for(int i=0; i<sizeOfPool; i++)
		{
			SingleThread s = new SingleThread(this.taskQueue, "Thread-"+(i+1));
			this.listOfThreads.add(s);
			s.start();
		}
	}
	
	public void submitTask(Runnable r)
	{
		this.taskQueue.offer(r);
	}
	
	public void shutDown()
	{
		
		for(SingleThread s: this.listOfThreads)
		{
			s.stopThread();
		}
	}
}
