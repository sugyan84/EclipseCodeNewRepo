package threading.findDuplicates;

import java.util.*;

public class findDuplicate implements Runnable
{

	public static HashMap	m	= new HashMap();
	List					l;
	int						numberToSearch;
	int						stIndex;

	public findDuplicate(List l, int startIndex, int n)
	{
		this.l = l;
		this.stIndex = startIndex;
		this.numberToSearch = n;
	}

	@Override
	public void run()
	{
		Iterator itr = this.l.iterator();

		int i = -1;
		while (itr.hasNext())
		{
			i++;
			int nowNumber = (Integer) itr.next();

			if(i >= this.stIndex)
			{
				if(nowNumber == this.numberToSearch)
				{
					// add to map
					addToMap(this.numberToSearch);
				}
			}
		}
	}

	private void addToMap(int n)
	{
		if(m.containsKey(n))
			m.put(n, (Integer) m.get(n) + 1);
		else
			m.put(n, 2);
	}

	public static void showMapContents()
	{
		System.out.println("Showing contents");

		Map<Integer, Integer> m1 = m;

		if(m1.size() == 0)
		{
			System.out.println("No duplicates found");
			return;
		}
		else
			for(Map.Entry<Integer, Integer> k : m1.entrySet())
			{
				System.out.println(k.getKey() + " is repeated " + k.getValue() + " times");
			}

	}
}
