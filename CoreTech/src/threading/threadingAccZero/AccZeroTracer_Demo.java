package threading.threadingAccZero;

import java.util.*;

public class AccZeroTracer_Demo
{
	

	public static void main(String[] args) throws InterruptedException
	{
		long startTime=System.currentTimeMillis();
		
		ArrayList<MyObject> myList= new ArrayList<MyObject>();
		
		Object[] ko= new Object[20];
		
		MyObject o1 = new MyObject("676302930");
		MyObject o2 = new MyObject("676300950");		//This
		MyObject o3 = new MyObject("67130290030");
		MyObject o4 = new MyObject("676302330");
		MyObject o5 = new MyObject("600630230");		//This
		MyObject o6 = new MyObject("676302900");		//This
		
		
		myList.add(o1);
		myList.add(o2);
		myList.add(o3);
		myList.add(o4);
		myList.add(o5);
		myList.add(o6);
		
		
		System.out.println("Traversing the fresh list ...");
		
		Iterator<MyObject> itr = myList.iterator();
		
		int k=0;
		while(itr.hasNext())
		{
			k++;
			MyObject nowObj = (MyObject)itr.next();
			System.out.println("o"+k+" ---> "+nowObj);
			
			MyThread t= new MyThread(nowObj);
			Thread thread= new Thread(t);
			thread.start();
			ko[k-1]=thread;
			
		}
	
		
		for(int r=0;ko[r]!=null;r++)
		{
			Thread u = (Thread)ko[r];
			if(u.isAlive()==true)
			{
				u.join();
			}
		}
		
		List l=MyThread.finalList;
System.out.println("Traversing the final list ...");
		
		Iterator<MyObject> itr2 = l.iterator();
		
		int p=0;
		while(itr2.hasNext())
		{
			p++;
			MyObject nowObj = (MyObject)itr2.next();
			System.out.println("o"+p+" ---> "+nowObj);
			
		}
		
		long endTime=System.currentTimeMillis();
		long timeTaken=endTime-startTime;
		
		System.out.println("Time taken: "+timeTaken);
		
	}

}
