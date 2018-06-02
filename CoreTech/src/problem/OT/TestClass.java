package problem.OT;

import java.util.HashMap;
import java.util.Map;

public class TestClass
{
	static final int[] a = {100, 200};
	
	static int[] arr;
	
	static
	{
		
	}
	
	public void changes()
	{
		Map map = new HashMap();
		
		map.put("a", "a");
		map.put("b", "b");
		
		swap(map);
		
		System.out.println(map.values());
	}

	private void swap(Map hmap)
	{
		hmap = new HashMap();
		
		hmap.put("x", "x");
		hmap.put("y", "y");
		
	}
	
	public static void main(String[] args)
	{
		new problem.OT.TestClass().changes();
	}
}
