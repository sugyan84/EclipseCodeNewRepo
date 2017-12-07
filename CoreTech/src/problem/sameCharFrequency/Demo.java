package problem.sameCharFrequency;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Demo
{

	public static void main(String[] args)
	{
		String str  = "abaccabb";
		
		HashMap<Character, Integer> m = new HashMap<Character, Integer>();
		
		char[] chrArr = str.toCharArray();
		
		for(char x: chrArr)
		{
			if(m.containsKey(x))
			{
				m.put(x, (Integer)m.get(x)+1);
			}
			else
			{
				m.put(x, 1);
			}
		}
		
		
		Iterator itr = m.entrySet().iterator();
		
		while(itr.hasNext())
		{
			Map.Entry<Character, Integer> me = (Map.Entry<Character, Integer>) itr.next();
			
			System.out.println(me.getKey()+"-->"+me.getValue());
		}
	}

}
