package problem.compete.junit;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class SampleTest
{

	problem.compete.Lenskart.TestClass obj = new problem.compete.Lenskart.TestClass();
	
	static List<Case> list = new ArrayList<>();
	
	@BeforeClass
	public static void initializeCases()
	{
		list.add(new Case("abc", 3));
		list.add(new Case("aabc", 3));
		list.add(new Case("abdppc", 5));
		list.add(new Case("aapbcpbc", 4));
		list.add(new Case("a", 1));
		
	}
	
	@Test
	public void test()
	{
		for(Case c: list)
		{
			looper(c.input, c.output);
		}
	}
	
	
	public void looper(String input, int output)
	{
		int actual = obj.getUniqueCharsCount(input);
		
		int expected = output;
		
		assertEquals(expected, actual);
	}

}

class Case
{
	String input;
	int output;
	public Case(String input, int output)
	{
		this.input = input;
		this.output = output;
	}
	
	
}
