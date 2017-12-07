package general;

public class TestThread implements Runnable
{
	static int	i;

	@Override
	public void run()
	{
		i = (int) Math.random() * 10;
		System.out.print("running....");
	}

	public static void main(String[] args)
	{
		Thread t = new Thread(new TestThread());
		while (i == 0)
		{
			System.out.print("start again....");
			t.start();
		}
	}
}
