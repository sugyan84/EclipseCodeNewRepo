package problem.compete.Heap;

import java.util.Comparator;

public class CustomComp implements Comparator<Integer>
{

	@Override
	public int compare(Integer arg0, Integer arg1)
	{
		return arg1.compareTo(arg0);
	}

}
