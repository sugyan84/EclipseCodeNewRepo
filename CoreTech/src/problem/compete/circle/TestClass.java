package problem.compete.circle;

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
            int x1 = s.nextInt();
            int y1 = s.nextInt();
            
            int x2 = s.nextInt();
            int y2 = s.nextInt();
            
            int r = s.nextInt();
            
            int m = 0;
            try
            {
            	m = (y2-y1)/(x2-x1);
            }
            catch(ArithmeticException e)
            {
            	m = 0;
            }
            
            int b = y1- (m*x1);
            int result = b;
           
            /*int xABS = Math.abs(x1-x2);
            int yABS = Math.abs(y1-y2);
            
            xABS = xABS*xABS;
            yABS = yABS*yABS;*/
            
           // int result = (int)Math.sqrt(xABS+yABS);
            
            if(result < r)
            {
            	//Inside
            	System.out.println("REPLANNING");
            }
            else if(result > r)
            {
            	//safe
            	System.out.println("SAFE");
            	
            }else if(result==r)
            {
            	//just touching
            	System.out.println("JUST MISSED");
            }
        }

    }
}
