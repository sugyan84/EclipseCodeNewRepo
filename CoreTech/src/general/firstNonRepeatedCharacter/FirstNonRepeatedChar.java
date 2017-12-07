package general.firstNonRepeatedCharacter;

import java.util.ArrayList;


//This program will find the first non-repeated character in a string
public class FirstNonRepeatedChar
{

	public static void main(String[] args)
	{
		String str= "ijkulfgsmpqaknzxc";
		
		ArrayList<Character> aList= new ArrayList<Character>();
		
		int i=0;
		
		for(i=0;(i<str.length() && aList.size()==0);i++)
		{
			for(int j=i+1;j<str.length();j++)
			{
				if(str.charAt(i)==str.charAt(j))
				{
					aList.add(str.charAt(i));
				}
			}
		}

		System.out.println("First repeating character is: "+aList.get(0));
		
		System.out.println(i);
	}

}
