package javaTrickyPrograms;

public class SyncMethods
{
	public synchronized void m1()
	{
	}

	public synchronized void m2()
	{
		m1();
	}

	public static void main(String[] args)
	{
		SyncMethods s = new SyncMethods();
		s.m2();
		System.out.println("Done");
	}
}