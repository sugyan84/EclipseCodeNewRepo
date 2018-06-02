package problem.compete.another10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

class TestClass6
{
	public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        long N = Long.parseLong(br.readLine().trim());
        
        Long[] arr = new Long[(int)N];
        
        int lastIndex = 0;
        int noOfElements = 0;
        
        for(int i=0; i<N; i++)
        {
        	String[] str = br.readLine().trim().split(" ");
        	
        	if(str.length==2)
        	{
        		//2
        		long newElement = Long.parseLong(str[1]);
        		
        		if(lastIndex <= N-1)
        		{
        			arr[lastIndex++] = newElement;
        			noOfElements++;
        		}
        	}
        	else
        	{
        		//1
        		Arrays.sort(arr, 0, lastIndex, Collections.reverseOrder());
        		
        		if(lastIndex-1 >= 2)
        		{
        			int getIndex = noOfElements/3;
        			
        			
        			System.out.println(arr[getIndex-1]);
        		}
        		else
        			System.out.println("Not enough enemies");
        	}
        	
        	
        }
        
        
        

    }
}
