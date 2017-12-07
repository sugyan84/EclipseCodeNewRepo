
public class Lobby
{
	public synchronized void methodA()
	{
		for(int i=0; i< 1000; i++)
		{
			System.out.println(Thread.currentThread().getName()+"--->>>"+i);
		}
	}
	
	
	public void methodB()
	{
		for(int i=0; i< 1000; i++)
		{
			System.out.println(Thread.currentThread().getName()+"--->>>"+i);
		}
	}

}
