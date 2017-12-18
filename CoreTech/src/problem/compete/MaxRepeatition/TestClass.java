package problem.compete.MaxRepeatition;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

class TestClass
{
	public static void main(String args[]) throws Exception
	{
		/*
		 * Sample code to perform I/O: Use either of these methods for input
		 */

		// BufferedReader

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name = br.readLine().trim(); // Reading input from STDIN
		// System.out.println("Hi, " + name + "."); // Writing output to STDOUT

		// Scanner
		/*
		 * Scanner s = new Scanner(System.in); String name = s.nextLine(); //
		 * Reading input from STDIN System.out.println("Hi, " + name + "."); //
		 * Writing output to STDOUT
		 * 
		 */

		// Write your code here

		int maxCount = 0;

		List<Character> maxChar = new ArrayList<Character>();

		Map<Character, Integer> m = new TreeMap<>();

		char[] chrArr = name.toCharArray();

		for(char c : chrArr)
		{
			if(m.containsKey(c))
			{
				// contains
				Integer i = m.get(c) + 1;

				m.put(c, i);
			}
			else
			{
				// not there
				m.put(c, 1);
			}
		}

		
		
		
		Set s = m.entrySet();
		
		Iterator itr = s.iterator();
		
		char lastKey = ' ';
		
		int max =0;
		
		while(itr.hasNext())
		{
			Map.Entry<Character, Integer> me2 = (Map.Entry) itr.next();
			
			if(me2.getValue() > max)
			{
				max = me2.getValue();
				lastKey = me2.getKey();
			}
			
			
			System.out.println("|"+me2.getKey()+"| "+me2.getValue());
		}
		
		
		//System.out.println(lastKey+" "+max);
		
		List l = new ArrayList<>(s);
		
		Collections.sort(l, new CustomComp());
		
		Map.Entry<Character, Integer> me = (Map.Entry<Character, Integer>) l.get(l.size()-1);
		
		System.out.println("Answer: |"+me.getKey()+"| "+me.getValue());

	}
}

class CustomComp implements Comparator
{

	@Override
	public int compare(Object o1, Object o2)
	{
		int retVal =0;
		
		Map.Entry<Character, Integer> m1 = (Map.Entry<Character, Integer>) o1;

		Map.Entry<Character, Integer> m2 = (Map.Entry<Character, Integer>) o2;

		
		int x = m1.getValue().compareTo(m2.getValue());
		
		if(m1.getValue() > m2.getValue())
		{
			retVal = 1;
		}
		else if(m1.getValue() < m2.getValue())
		{
			retVal = -1;
		}
		else
			if(m1.getValue()== m2.getValue())
			{

				char c1 = m1.getKey();
				char c2 = m2.getKey();
				
				int i1 = c1;
				
				int i2 = c2;
				
				if(i1 < i2)
				{
					retVal = 1;
				}
				else if(i1 > i2)
				{
					retVal = -1;
				}
			
			}
		
		/*if(x == 0)
		{
			char c1 = m1.getKey();
			char c2 = m2.getKey();
			
			int i1 = c1;
			
			int i2 = c2;
			
			if(i1 < i2)
			{
				retVal = -1;
			}
			else if(i1 > i2)
			{
				retVal = 1;
			}
		}*/
		
		return retVal;
	}

}
