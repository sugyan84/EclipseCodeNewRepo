package problem.compete.junit;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class MyNumberParameterizedTest
{
	private MyNumber	number1, number2;	// Test fixtures
	private int			result;

	@Parameters
	// Feed inputs to constructor
	public static Iterable<Object[]> data()
	{
		System.out.println("Run @Parameters");
		return Arrays.asList(new Object[][]
		{
				{ new MyNumber(1), new MyNumber(2), 3 },
				{ new MyNumber(-1), new MyNumber(-2), -3 },
				{ new MyNumber(3), new MyNumber(-3), 0 }, });
	}

	// Constructor
	// For each test, this constructor gets its inputs from
	// the @Parameters method to setup the test fixtures.
	public MyNumberParameterizedTest(MyNumber number1, MyNumber number2, int result)
	{
		System.out.println("Run constructor");
		this.number1 = number1;
		this.number2 = number2;
		this.result = result;
		System.out
				.println("-- number1=" + number1.getNumber() + " number2=" + number2.getNumber() + " result=" + result);
	}

	@Before
	// Run after constructor, before @Test
	public void setUp() throws Exception
	{
		System.out.println("	Run @Before");
		System.out.println("	-- number1=" + number1.getNumber() + " number2=" + number2.getNumber());
	}

	@Test
	public void test()
	{
		System.out.println("		Run @Test");
		assertEquals(result, number1.add(number2).getNumber());
	}

}