
public class Box
{
	String name;
	
	public Box(String n)
	{
		this.name= n;
	}
	
	public static synchronized void StaticSync()
	{
		System.out.println(Thread.currentThread().getName()+ "-->SM1");
		System.out.println(Thread.currentThread().getName()+ "-->SM2");
	}
	
	public synchronized void Sync()
	{
		System.out.println(Thread.currentThread().getName()+ "-->"+this.name+"-M1");
		System.out.println(Thread.currentThread().getName()+ "-->"+this.name+"-M2");
	}
	
public static void main(String[] args) throws InterruptedException
{
	Box obj= new Box("O1");
	
	Thread t1 = new Thread("Thread-1") {
		
		public void run()
		{
			obj.Sync();
		}
	};
	
	
Thread t2 = new Thread("Thread-2") {
		
		public void run()
		{
			obj.StaticSync();
		}
	};
	
	
Thread t3 = new Thread("Thread-3") {
		
		public void run()
		{
			obj.StaticSync();
		}
	};
	
	
	t1.start();
	t2.start();
	t3.start();
	
	t1.join();
	t2.join();
	t3.join();


}

}
