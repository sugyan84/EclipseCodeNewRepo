package problem.compete.Another2;

import java.util.*;
import java.io.*;


class TestClass 
{
    public static void main(String args[] ) throws Exception 
    {
        
        
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Scanner s = new Scanner(System.in);
        
        int T = s.nextInt();

        for(int i=0; i<T; i++)
        {
        	int num = s.nextInt();
        	
        	String str = String.valueOf(num);
        	
        	if(str.contains("21") || (num%21==0))
        	{
        		System.out.println("The streak is broken!");
        	}
        	else
        		System.out.println("The streak lives still in our heart!");
        }

    }
}

