package threading;

public class DemoPrinterThread
{

	public static void main(String[] args)
	{
		Printer poss= new Printer();
		
		TaskEvenOdd r = new TaskEvenOdd(poss);
		
		Thread t1= new Thread(r,"Thread-1");
		Thread t2= new Thread(r,"Threade-2");
		
		t1.start();
		t2.start();

	}

}
