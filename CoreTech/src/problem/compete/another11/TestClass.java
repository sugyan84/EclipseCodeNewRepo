package problem.compete.another11;

import java.util.*;
import java.io.*;


class TestClass 
{
    public static void main(String args[] ) throws Exception 
    {
        
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Scanner s = new Scanner(System.in);
        
        int T = s.nextInt();
        
        int N = s.nextInt();

        for(int i=0; i<T; i++)
        {
        	for(int j=0; j<N; j++)
            {
            	String[] strSplit = br.readLine().split(" ");
            	
            	int S = Integer.parseInt(strSplit[0]);
            	int R = Integer.parseInt(strSplit[1]);
            	
            	HashSet<Integer> set = new HashSet();
            	
            	if(!set.add(S))
            	{
            		//already present
            	}
            	else
            	{
            		//not present
            	}
            }
        }

    }
}
