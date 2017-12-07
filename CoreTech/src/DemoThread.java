
public class DemoThread
{

	public static void main(String[] args)
	{

		Lobby obj = new Lobby();
		
		Thread t1 = new Thread("T-1") {
			public void run()
			{
				obj.methodA();
			}
		};
		
		
		
		Thread t2 = new Thread("T-2") {
			public void run()
			{
				obj.methodB();
			}
		};
		
		
		t1.start();
		t2.start();
	}

}
