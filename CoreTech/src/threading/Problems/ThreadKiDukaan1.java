package threading.Problems;

public class ThreadKiDukaan1 implements Runnable
{

	SynchMethodsThreads local1;
	
	ThreadKiDukaan1(SynchMethodsThreads s)
	{
		this.local1 = s;
	}
	
	
	@Override
	public void run()
	{
		local1.staticSyncMethod();
	}

}



class ThreadKiDukaan2 implements Runnable
{

	SynchMethodsThreads localObj;
	
	ThreadKiDukaan2(SynchMethodsThreads s)
	{
		this.localObj = s;
	}
	
	
	@Override
	public void run()
	{
		localObj.staticSyncMethod();
	}

}