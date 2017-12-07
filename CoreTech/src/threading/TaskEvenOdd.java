package threading;

public class TaskEvenOdd implements Runnable
{

	Printer p;
	int count=1;
	
	public TaskEvenOdd(Printer p)
	{
		this.p = p;
	}


	
	public void run()
	{
		//System.out.println("In run() method");
		
		while(count<10)
		{
			//System.out.println("Count is: "+count);
			
			if(count%2==0)
			{
				//System.out.println("Inside even block...");
				p.printEven(count);
				count++;
			}
			else
			{
				//System.out.println("Inside odd block...");
				p.printOdd(count);
				count++;
			}
		}
		
	}

}
