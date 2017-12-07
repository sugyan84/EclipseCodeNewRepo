package exception;

public class ClassCastExample
{

	public static void main(String[] args)
	{
		Object i = Integer.valueOf(42);
		
		String sr = (String)i;
		boolean s=(i instanceof Object);
		
		System.out.println(s);

	}

}
