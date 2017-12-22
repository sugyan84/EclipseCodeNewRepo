package problem.compete.MazeProblem;

import java.util.HashSet;
import java.util.Scanner;


class TestClass 
{
    static int[][] matrix = null;
    
    static int n=0;
    
    static int count=0;
    
    static int  numberOfPaths()
    {
    	int retVal=0;
    	
    	if(move(0, 0))
    		System.out.println(count);
    	else
    		System.out.println(count);
    	
    	return retVal;
    }
    
    public static boolean isSafe(int i, int j)
    {
    	if(i<n && j<n && i>=0 && j>=0)
    		return true;
    	else
    		return false;
    }
    
    public static boolean move(int i, int j)
    {
    	boolean retVal=false;
    	
    	if(i==n-1 && j==n-1 && matrix[i][j]==0)
    	{
    		//destination reached
    		count++;
    		return true;
    	}
    	
    	
    	if(matrix[i][j]==1)
    	{
    		return false;
    	}
    	
    	if(matrix[i][j]==0)
    	{
    		//Move right
    		boolean rightPossible= false;
    		if(isSafe(i, j+1))
    		 rightPossible = move(i, j+1);
    		
    		
    		//Move down
    		boolean downPossible= false;
    		if(isSafe(i+1, j))
    			downPossible = move(i+1, j);
    		
    		
    		if(rightPossible || downPossible)
    		{
    			return true;
    		}
    	}
    	
    	
    	
    	return retVal;
    }
    
    
    public static void main(String args[] ) throws Exception 
    {
        
        
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Scanner s = new Scanner(System.in);
        
        int T = s.nextInt();
        
        n = T;
        
        matrix = new int[T][T];

        for(int i=0; i<T; i++)
        {
            for(int j=0; j<T; j++)
            {
                matrix[i][j] = s.nextInt();
            }
        }
        
        numberOfPaths();
        

    }
}
