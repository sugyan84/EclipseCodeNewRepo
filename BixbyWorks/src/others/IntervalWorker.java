package others;

public class IntervalWorker
{

	static int i=0;
	static long executeInterval;		//milli-seconds holder.
	
	//Set your Interval Requirement.
	static int hr=0;
	static int min=0;
	static int sec=3;
	
	
	//Initialize Interval time
	static
	{
		executeInterval= hr*60*60*1000;
		executeInterval= executeInterval+(min*60*1000);
		executeInterval= executeInterval+(sec*1000);
	}
	
	public static void main(String[] args) throws InterruptedException
	{
		
		while(true)
		{
			doTask();
			
			Thread.sleep(executeInterval);
		}		
	}
	
	
	
	//Some non-sense task
	public static void doTask()
	{
		i++;
		int lastDigit= i%10;			//Get the last Digit of the Number
		
		if(lastDigit==1 && i!=11)
			System.out.println("I'm doing my task "+i+"st time.");
		else if(lastDigit==2 && i!=12)
			System.out.println("I'm doing my task "+i+"nd time.");
		else if(lastDigit==3 && i!=13)
			System.out.println("I'm doing my task "+i+"rd time.");
		else
			System.out.println("I'm doing my task "+i+"th time.");
	}

}
