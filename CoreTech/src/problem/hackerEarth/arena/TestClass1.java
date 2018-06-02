package problem.hackerEarth.arena;

import java.util.HashSet;

public class TestClass1
{
	static int[] arr = { -1, 0, 0, 1, 1, 3, 3 };
	static HashSet<Integer>	nonLeafNodes	= new HashSet<Integer>();
	static HashSet<Integer>	leafNodes		= new HashSet<Integer>();

	private static boolean isLeafNode(int x)
	{
		if(x > arr.length || x < 0)
			throw new IllegalArgumentException();
		
		if(!nonLeafNodes.contains(x))
			return true;
		else
			return false;
	}

	public static void main(String[] args)
	{

		for (int i = 1; i < arr.length; i++)
		{
			nonLeafNodes.add(arr[i]);
		}
		
		for(int j=(arr.length-1); j>=0; j--)
		{
			if(isLeafNode(arr[j]))
			{
				//prop
			}
			
		}

	}

}
