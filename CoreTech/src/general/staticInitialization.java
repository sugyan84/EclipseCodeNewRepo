package general;

//this program is to test which exception is thrown if static variable is not initialized.
public class staticInitialization
{

	static int i;
	
	public static void main(String[] args)
	{
		System.out.println("start");
		try
		{
			while(i>0)
			{
				System.out.println("hello");
				i--;
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		

	}

}
