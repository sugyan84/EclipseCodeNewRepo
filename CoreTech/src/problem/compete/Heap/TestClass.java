package problem.compete.Heap;

import java.util.*;
import java.io.*;


class TestClass 
{
    public static void main(String args[] ) throws Exception 
    {
        
        
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Scanner s = new Scanner(System.in);
        
        int M = s.nextInt();
        
        int N = s.nextInt();

        PriorityQueue<Integer> p = new PriorityQueue<>(new CustomComp());
        
        int sum =0;
        
        for(int i=0; i<M; i++)
        {
        	p.add(s.nextInt());
        }
    	
        
        for(int j=1; j<=N; j++)
        {
        	int peekedVal = p.poll();
        	
        	if(peekedVal > 0)        	
        	sum += peekedVal;
        	
        	
        	p.add(peekedVal-1);
        	
        }
        
        
        System.out.println(sum);
    	
    	
    	

    }
}
