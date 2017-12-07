package threading.findDuplicates;

import java.util.*;


/*This program finds duplicate elements in a List, infact there will be multiple list 
and program find the 
duplicate elements in same List and also records the repetition time of each element.*/

public class Demo
{

	public static void main(String[] args) throws InterruptedException
	{
		List[] arr = new List[4];
		Set s= new HashSet();
		
		//Initializing the scenario
		for(int i=1;i<=4;i++)
		{
			List l = new ArrayList();
			int k=0;
			
			do{
			Random r = new Random();
			k = r.nextInt(15);
			}while(k<=5);
			
			for(int j=1;j<=k;j++)
			{
				Random rr = new Random();
				l.add(rr.nextInt(12));
			}
			arr[i-1]=l;
		}

		
		//Showing the initialization
		for(int i=1;i<=4;i++)
		{
			List ll = arr[i-1];
			
			Iterator itr = ll.iterator();
			
			System.out.println("List "+i);
			while(itr.hasNext())
			{
				System.out.print(itr.next()+" ");
			}
			System.out.println("\n");
			
		}
		System.out.println("-----------------------------------------------------------");
		
		
		
		//------------------------------------------------------------
		List lk = new ArrayList();
		lk= arr[0];
		Thread[] tArray = new Thread[lk.size()];
		
		Iterator p = lk.iterator();
		
		int o= -1;
		while(p.hasNext())
		{
			o++;
			
			int y = (Integer)p.next();
			
			boolean b =s.add(y);
			
			if(b)
			{
				findDuplicate f = new findDuplicate(lk, o+1, y);
				Thread t = new Thread(f);
				t.start();
				tArray[o]=t;
			}
			
		}
		
		
		for(int q=0;q<tArray.length-1;q++)
		{
			if(tArray[q]!=null)
			tArray[q].join();
		}
		
		findDuplicate.showMapContents();
		
	}

}
