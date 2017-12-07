package comparing;

import java.util.HashSet;
import java.util.TreeSet;

public class Test2
{

	public static void main(String[] args)
	{
		TreeSet s = new TreeSet();
		
		System.out.println(s.add(new Country("USA", 3, 13, 2)));
		System.out.println(s.add(new Country("PAK", 2, 15, 7)));
		System.out.println(s.add(new Country("EGP", 4, 7, 0)));
		System.out.println(s.add(new Country("USA", 5, 4, 3)));
		System.out.println(s.add(new Country("EGP", 5, 4, 5)));
		
		
		System.out.println(s);
	}
}
