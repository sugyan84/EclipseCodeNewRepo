package algos.dynamicProgramming;

public class StringRecursiveReverse
{

	public static String reverse(String name)
	{
		String retValue="";
		
		int len= name.length()-1;
		
		if(name.length()==0)
			return retValue;
		
		if(name.length()==1)
			retValue=name;
		else if(name.length()>1)
		{
			retValue = name.charAt(len)+reverse(name.substring(0, len));
		}
			
		return retValue;
		
		
		
	}
	
	
	public static void main(String[] args)
	{
		System.out.println(reverse("Sugyan"));
		
		//System.out.println("Sugyan".substring(0, 1));
	}

}
