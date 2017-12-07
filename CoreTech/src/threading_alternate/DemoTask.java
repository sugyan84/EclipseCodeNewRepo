package threading_alternate;

public class DemoTask
{

	public static void main(String[] args) throws InterruptedException
	{
		Master mobj= new Master();
		
		Task r = new Task(mobj);
		
		Thread t1= new Thread(r,"Even");
		Thread t2= new Thread(r,"Odd");
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		Thread.sleep(2000);
		System.out.println("All Threads finished");

	}

}
