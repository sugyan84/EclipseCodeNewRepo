package exception;

public class DemoTryCatchFinally
{

	public static void main(String[] args)
	{
		try
		{
			System.out.println(10/0);
		}
		catch(Exception e)
		{
			System.out.println("Exception");
			//System.exit(0);
			
		}		
		/*catch(ArithmeticException ae)
		{
			System.out.println("Ae");
		}*/finally
		{
			System.out.println("finally");
		}

	}

}
