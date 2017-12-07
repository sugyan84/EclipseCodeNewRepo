package StringOps;

public class StringCompareManually
{

	public static boolean isEqual(String str1, String str2)
	{
		boolean isEqual=true;
		int len=0;
		
		if(str1.toCharArray().length!=str2.toCharArray().length)
			isEqual=false;
		else
		{
			 len=str1.length();
		}
		
		
		for(int i=0,k=len-1; (i<(len/2) && k>=0); i++,k--)
		{
			if((str1.charAt(i)!=str2.charAt(i)) || (str1.charAt(k)!=str2.charAt(k)))
			{
				isEqual=false;
				break;
			}
		}
		
		return isEqual;		
	}
	
	public static void main(String[] args)
	{
			System.out.println(isEqual("SUgyan","Sugyan"));
	}

}
