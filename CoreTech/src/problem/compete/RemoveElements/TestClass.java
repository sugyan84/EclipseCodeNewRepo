package problem.compete.RemoveElements;

import java.util.*;
import java.io.*;


class TestClass 
{
	static List<Integer> l = new ArrayList();
	
    public static void main(String args[] ) throws Exception 
    {
        
        
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Scanner s = new Scanner(System.in);
        
        int T = s.nextInt();

        for(int i=0; i<T; i++)
        {
        	long N = s.nextLong();
        	
        	for(long j=0; j<N; j++)
        	{
        		l.add((int) s.nextLong());
        	}
        	
        	Collections.sort(l);
        	
        	int index = l.size()-1;
        	
        	int count=0;
        	
        	while(l.size()!=0)
        	{
        		count++;
        		
        		index = l.size()-1;
        		
        		long pickedX = l.get(index);
        		
        		l.remove(index);
        		
        		if(index >=1 && l.isEmpty()==false)
        		{
        			if(l.get(index-1)==pickedX-1)
            		{
            			l.remove(index-1);
            		}
        		}
        		
        		
        	}
        	
        	System.out.println(count);
        	
        }

    }
}
