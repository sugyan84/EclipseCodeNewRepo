package problem.compete.Another3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


class TestClass 
{
    public static void main(String args[] ) throws Exception 
    {
        
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Scanner s = new Scanner(System.in);
        
        /*int N = s.nextInt();
        
        int Q = s.nextInt();*/

        String[] firstLine = br.readLine().split(" ");
        
        int N = Integer.parseInt(firstLine[0]);
    	int Q = Integer.parseInt(firstLine[1]);
        
        String str = br.readLine();
        
        char[] arr = str.toCharArray();
        
        for(int i=0; i<Q; i++)
        {
        	String[] line = br.readLine().split(" ");
        	
        	int L = Integer.parseInt(line[0])-1;
        	int R = Integer.parseInt(line[1])-1;
        	int K = Integer.parseInt(line[2]);
        	
        	List<Character> l = new ArrayList<>(Math.abs(L-R)+1);
        	
        	for(int j=L; j<=R; j++)
        	{
        		l.add(arr[j]);
        	}
        	
        	Collections.sort(l);
        	
        	try
        	{
        		System.out.println(l.get(K-1));
        		
        	}catch(Exception e)
        	{
        		System.out.println("Out of range");
        	}
        	
        }

    }
}

