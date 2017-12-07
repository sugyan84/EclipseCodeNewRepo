package threading.Problems;

public class Demo
{

	public static void main(String[] args)
	{
		SynchMethodsThreads s1 = new SynchMethodsThreads();		
		SynchMethodsThreads s2 = new SynchMethodsThreads();
		
		ThreadKiDukaan1 st1 = new ThreadKiDukaan1(s1);		//Which Object (Specify here in Parameter)
		Thread t1 = new Thread(st1, "T1");
		
		t1.start();
		
		
		
		ThreadKiDukaan2 st2 = new ThreadKiDukaan2(s2);		//Which Object (Specify here in Parameter)
		Thread t2 = new Thread(st2, "T2");
		
		t2.start();
	}

}
