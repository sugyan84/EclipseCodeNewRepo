package problem.compete.another10;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class TestClass1
{

	static Map<Long, List<Long>>	treeList	= new HashMap();

	static long[]					prices		= null;

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		long N = sc.nextLong();
		long Q = sc.nextLong();

		for (long i = 0; i < (N - 1); i++)
		{
			long a = sc.nextLong();

			long b = sc.nextLong();

			if(treeList.containsKey(a))
			{
				List l = treeList.get(a);
				l.add(b);
				treeList.put(a, l);
			}
			else
			{
				List l = new LinkedList();
				l.add(b);
				treeList.put(a, l);
			}
		}

		prices = new long[(int) N];

		for (int i = 0; i < N; i++)
		{
			prices[i] = sc.nextLong();
		}

		for (int i = 0; i < Q; i++)
		{
			long U = sc.nextLong();
			long L = sc.nextLong();
			long R = sc.nextLong();

			System.out.println(getFreqUnderNode(U, L, R));
		}

	}

	private static int getFreqUnderNode(long u, long left, long right)
	{
		int count = 0;

		Map<Long, Integer> freqList = new HashMap();

		Queue<Long> queue = new LinkedList();

		queue.add(u);

		while (!queue.isEmpty())
		{
			long currElement = queue.poll();

			// get Price and add to HashMap
			int index = (int) (currElement - 1);
			long p = prices[index];

			if(freqList.containsKey(p))
			{
				int existingCount = freqList.get(p);
				freqList.put(p, existingCount + 1);
			}
			else
			{
				freqList.put(p, 1);
			}

			// get its children
			boolean check = treeList.containsKey(currElement);
			
			if(check)
			{
				List<Long> l = treeList.get(currElement);

				for (long x : l)
				{
					queue.add(x);
				}
			}
		}

		Iterator itr = freqList.entrySet().iterator();

		while (itr.hasNext())
		{
			Map.Entry<Long, Integer> me = (Map.Entry<Long, Integer>) itr.next();

			int currElem = me.getValue();

			if(currElem >= left && currElem <= right)
			{

				count++;
			}
		}

		return count;
	}

}
