package StringOps;

public class WordCount
{

	public static void withoutInBuilt()
	{
		String inputString="I have a problem in Java";
		
		char[] charString=inputString.toCharArray();
		
		int count=0;
		
		for(char a : charString)
		{
			
			if(a==' ')
				count++;
		}
		
		System.out.println(count+1);
	}
	
	
	public static void  usingInBuilt()
	{
		String inputString="I have a problem in Java";
		
		String[] splitString = inputString.split(" ");
		
		System.out.println(splitString.length);
	}
	
	public static void main(String[] args)
	{
		

		usingInBuilt();
	}

}
