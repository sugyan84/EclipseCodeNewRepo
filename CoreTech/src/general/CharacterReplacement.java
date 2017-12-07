package general;

public class CharacterReplacement
{

	//This method returns another character forward of the character passed to it.
	public static char changeCharacter(char charToChange, int forwardBy)
	{
		int incrementTimes = forwardBy;

		char originalCharacter = charToChange;
		int initialASCII=originalCharacter;
		int originalASCII = 0;
		
		char newCharacter=' ';

		originalASCII = originalCharacter;

		for(int count = 1; count <= incrementTimes; count++)
		{
			originalASCII++;
			
			if(originalASCII> 122 && (initialASCII>=97 && initialASCII<=122))
			{
				originalASCII=97;
			}
			else if(originalASCII> 90 && (initialASCII>=65 && initialASCII<=90))
				originalASCII=65;
				
		}

		newCharacter=(char)originalASCII;
		
		return newCharacter;
	}
	
	public static void main(String[] args)
	{
		String str="Sugyan";
		
		for(char x: str.toCharArray())
		{
			System.out.print(changeCharacter(x,2));
		}

	}

}
