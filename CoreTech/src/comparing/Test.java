package comparing;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class Test
{

	public static void main(String[] args)
	{
		TreeSet list = new TreeSet(new CompareClass());

		list.add(new Country("USA", 3, 13, 2));
		list.add(new Country("PAK", 2, 15, 7));
		list.add(new Country("EGP", 4, 7, 0));
		list.add(new Country("USA", 5, 4, 3));
		list.add(new Country("EGP", 5, 4, 5));

		// Collections.sort(list, new CompareClass());

		Iterator itr = list.iterator();

		while (itr.hasNext())
		{
			System.out.println(itr.next());
		}

	}

}
