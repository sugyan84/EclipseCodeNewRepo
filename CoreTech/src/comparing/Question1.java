package comparing;


import java.io.*;
import java.util.*;

public class Question1
{

	public static void main(String[] args)
	{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		LinkedHashSet s = new LinkedHashSet();
		
		HashMap m=new HashMap<String, Country>();
		
		String str=null;
		String[] strArr;
		
		try
		{
			String noOfTimes=br.readLine();
			int t=Integer.valueOf(noOfTimes);
			
			for(int i=1;i<=t;i++)
			{
				str=br.readLine();
				
				//s.add(str);
				
				strArr=str.split(" ");
				
				for(int j=1;j<=3;j++)
				{
					if(m.containsKey(strArr[j-1]))
					{
						Country c= (Country) m.get(strArr[j-1]);
						int medalCount=0;
						
						if(j==1) 
							{
								medalCount=c.getGold();
								medalCount=medalCount+1;
								c.setGold(medalCount);
								m.put(strArr[j-1], c);
							}
						else if(j==2) 
							{
								medalCount=c.getSilver();
								medalCount=medalCount+1;
								c.setSilver(medalCount);
								m.put(strArr[j-1], c);
							}
						else if(j==3) 
							{
								medalCount=c.getBronze();
								medalCount=medalCount+1;
								c.setBronze(medalCount);
								m.put(strArr[j-1], c);
							}
					}
					else
					{
						if(j==1) 
						{
							m.put(strArr[j-1], new Country(strArr[j-1], 1, 0, 0));
						}
					else if(j==2) 
						{
							m.put(strArr[j-1], new Country(strArr[j-1], 0, 1, 0));
						}
					else if(j==3) 
						{
							m.put(strArr[j-1], new Country(strArr[j-1], 0, 0, 1));
						}
					}
				}
			}
			
		}catch(Exception e)
		{
			
		}

		System.out.println();
		Set set=m.keySet();
		Iterator itr = set.iterator();

		while (itr.hasNext())
		{
			System.out.println(itr.next());
		}
	}

}
