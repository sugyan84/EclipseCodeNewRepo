package threading.threadingAccZero;

import java.util.ArrayList;

public class MyThread implements Runnable
{

	MyObject obj=null;
	static ArrayList<MyObject> finalList= new ArrayList<MyObject>();
	
	public synchronized void selectObject(MyObject ot)
	{
		finalList.add(ot);
	}
	
	public MyThread(MyObject obj)
	{
		
		this.obj = obj;
	}


	@Override
	public void run()
	{
		if(obj.isZero())
		{
			//add to finalList Collection
			selectObject(obj);
		}
		
	}

}
