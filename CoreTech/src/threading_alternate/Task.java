package threading_alternate;

public class Task implements Runnable
{
	static int num=1;
	static int count=1;
	Master m;

	public Task(Master m)
	{
		this.m = m;
	}

	@Override
	public void run()
	{
		try
		{
			m.print();
		}
		catch(InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	

}
