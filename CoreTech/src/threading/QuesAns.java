package threading;

public class QuesAns
{
	static boolean  status=true;
	
	public void printReply(int x)
	{
		if(status)
		{
			System.out.println(Thread.currentThread().getName()+" Ques-"+x);
			
			status=false;
			
			
			synchronized(this){
			while(status==false){
			try
			{
				wait();
			}
			catch(InterruptedException e)
			{
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println("Sahu");
			}
			}
			}
			notifyAll();
		}
		else if(!status)
		{
			System.out.println(Thread.currentThread().getName()+" Ans-"+x);
			
			status=true;
			
			
			synchronized(this){
			while(status==true){
			try
			{
				wait();
			}
			catch(InterruptedException e)
			{
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println("Ritika");
			}
			}
			}
			notifyAll();
		}
	}
}
