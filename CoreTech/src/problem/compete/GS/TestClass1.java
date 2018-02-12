package problem.compete.GS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestClass1
{
	static String findQualifiedNumbers(int[] numberArray)
	{
		List<Integer> list = new ArrayList<>();

		for (int num : numberArray)
		{
			if(isQualified(num))
			{
				list.add(num);
			}
		}

		Collections.sort(list);

		StringBuffer sbfr = new StringBuffer();

		for (int i = 0; i < list.size(); i++)
		{
			sbfr.append(list.get(i));
			if((i + 1) < list.size()) sbfr.append(",");
		}

		if(list.size() == 0)
		{
			sbfr = new StringBuffer();
			sbfr.append("-1");
		}

		return sbfr.toString();
	}

	public static boolean isQualified(int n)
	{
		boolean retVal = false;

		/*String number = String.valueOf(n);

		if(number.contains("1") && number.contains("2") && number.contains("3"))
		{
			retVal = true;
		}*/

		boolean a = false;
		boolean b = false;
		boolean c = false;

		while (n > 0)
		{
			int rem = n % 10;

			switch (rem)
			{
			case 1:
				a = true;

				break;
			case 2:
				b = true;
				break;
			case 3:
				c = true;
				break;
			default:
				break;
			}

			n = n/10;
		}
		
		if(a && b && c)
		{
			retVal = true;
		}

		return retVal;
	}

	public static void main(String[] args)
	{
		int[] sampleArr =
		{ 1456, 345671, 43218, 123 };

		String ans = findQualifiedNumbers(sampleArr);

		System.out.println(ans);

		// System.out.println(isQualified(1345));
	}
}
