package threading;

public class ThreadBox extends Thread
{
	static QuesAns obj=null;
	
	//String name;
	
	ThreadBox(QuesAns o)
	{
		ThreadBox.obj=o;
		
	}
	
	public void run()
	{
		for(int i=1;i<=8;i++)
		{
			try
			{
				Thread.sleep(800);
			}
			catch(InterruptedException e)
			{
				// TODO Auto-generated catch block
				System.out.println("Sugyan");
			}
			obj.printReply(i);
		}
	}
}
