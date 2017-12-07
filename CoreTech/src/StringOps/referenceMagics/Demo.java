package StringOps.referenceMagics;

public class Demo
{
	public static StringBuffer method(StringBuffer pStr)
	{
		pStr.append(" Sahu");
		
		System.out.println("pStr= "+pStr);
		
		return pStr;
	}

	public static void main(String[] args)
	{
		StringBuffer mainStr = new StringBuffer("Sugyan");
		
		StringBuffer mainStr2 = mainStr;
		
		mainStr2 = method(mainStr2);
		
		System.out.println("mainStr2= "+mainStr2);
	}

}
