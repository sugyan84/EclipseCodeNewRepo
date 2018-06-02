package problem.techgig;

import java.util.HashSet;
import java.util.Set;

public class MissingElement
{
	public static int countDuplicates(String input1)
    {
	    //Write code here
		Set<Character> set = new HashSet();
		
		char[] arr = input1.toCharArray();
		
		int count=0;
		
		for(char x : arr)
		{
			if(!set.add(x))
				count++;
		}
		
		return count;
    }
}
